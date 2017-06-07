/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.test;

import java.awt.Point;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nhchon on 3/23/2017 5:43 PM.
 */
public class ParallelSortTest {
    static final int width = 100;
    static final int height = 10;
    final Comparator<Point> comparator = Comparator.comparingInt(p -> p.x*p.x + p.y*p.y);

    private Point[] prepareData() {
        Point[] pixels = new Point[width*height];
        int idx = 0;
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                pixels[idx++] = new Point(x, y);
        return pixels;
    }

    public List<Point> sortPlain(Point[] data) {
        List<Point> list = Arrays.asList(data);
        Collections.sort(list, comparator);
        return list;
    }

    public List<Point> sortParallel(Point[] data) {
        Arrays.parallelSort(data, comparator);
        return Arrays.asList(data);
    }

    public List<Point> sortStream(Point[] data) {
        return Stream.of(data).sorted(comparator).collect(Collectors.toList());
    }

    public List<Point> sortParallelStream(Point[] data) {
        return Stream.of(data).parallel().sorted(comparator).collect(Collectors.toList());
    }

    void run(String mode) throws Exception {
        Method m = getClass().getMethod("sort"+mode, Point[].class);
        m.setAccessible(true); // makes invocation faster
        for(int i=0; i<20; i++) {
            Point[] data = prepareData();
            long start = System.nanoTime();
            @SuppressWarnings("unchecked")
            List<Point> result = (List<Point>) m.invoke(this, new Object[] {data});
            long end = System.nanoTime();
            long diff = end-start;
            if(data.length != result.size())
                System.out.println("Result size is wrong!");
            for(int j=1; j<result.size(); j++) {
                if(comparator.compare(result.get(j-1), result.get(j)) > 0)
                    System.out.println("Result is not sorted at position#"+j);
            }
            System.out.printf(Locale.ENGLISH, "#%02d: %.5fs%n", i + 1, ((double) diff)
                    / TimeUnit.SECONDS.toNanos(1));
        }
    }

    Stream<String> modes() {
        return Stream.of(getClass().getMethods()).map(Method::getName)
                .filter(m -> m.startsWith("sort")).map(m -> m.substring("sort".length()));
    }

    public static void main(String[] args) throws Exception {
        ParallelSortTest test = new ParallelSortTest();
        if(args.length != 1 || test.modes().noneMatch(args[0]::equals)) {
            System.out.println("Use java " + test.getClass().getName()
                    + " <mode>\nAvailable modes: "
                    + test.modes().collect(Collectors.joining(", ")));
        } else {
            test.run(args[0]);
        }

        System.out.println("=== TEST PERFORMANCE " + width +" x " + height +" = " +(width*height) +" elems  ===");
        // ParallelStream, Stream, Parallel, Plain
        System.out.println("ParallelStream");
        test.run("ParallelStream");
        //System.out.println("Stream");
        //test.run("Stream");
        //System.out.println("Parallel");
        //test.run("Parallel");
        //System.out.println("Plain");
        //test.run("Plain");
    }
}
