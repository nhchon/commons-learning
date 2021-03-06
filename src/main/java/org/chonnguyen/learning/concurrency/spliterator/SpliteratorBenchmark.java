/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.concurrency.spliterator;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.chonnguyen.learning.concurrency.spliterator.FixedBatchSpliterator.withBatchSize;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SpliteratorBenchmark
{
    static double sink;

    public static void main(String[] args) throws IOException {
        final Path inputPath = createInput();
        for (int i = 0; i < 3; i++) {
            System.out.println("Start processing JDK stream");
            measureProcessing(Files.lines(inputPath));
            System.out.println("Start processing fixed-batch stream");
            measureProcessing(withBatchSize(Files.lines(inputPath), 60));
        }
    }

    private static void measureProcessing(Stream<String> input) throws IOException {
        final long start = System.nanoTime();
        try (Stream<String> lines = input) {
            final long totalTime = lines.parallel()
                    .mapToLong(SpliteratorBenchmark::processLine).sum();
            final double cpuTime = totalTime, realTime = System.nanoTime()-start;
            final int cores = Runtime.getRuntime().availableProcessors();
            System.out.println("          Cores: " + cores);
            System.out.format("       CPU time: %.2f s\n", cpuTime/SECONDS.toNanos(1));
            System.out.format("      Real time: %.2f s\n", realTime/SECONDS.toNanos(1));
            System.out.format("CPU utilization: %.2f%%\n\n", 100.0*cpuTime/realTime/cores);
        }
    }

    private static long processLine(String line) {
        final long localStart = System.nanoTime();
        double d = 0;
        for (int i = 0; i < line.length(); i++)
            for (int j = 0; j < line.length(); j++)
                d += Math.pow(line.charAt(i), line.charAt(j)/32.0);
        sink += d;
        return System.nanoTime()-localStart;
    }

    private static Path createInput() throws IOException {
        final Path inputPath = Paths.get("input.txt");
        try (PrintWriter w = new PrintWriter(Files.newBufferedWriter(inputPath))) {
            for (int i = 0; i < 6_002; i++) {
                final String text = String.valueOf(System.nanoTime());
                for (int j = 0; j < 15; j++) w.print(text);
                w.println();
            }
        }
        return inputPath;
    }
}