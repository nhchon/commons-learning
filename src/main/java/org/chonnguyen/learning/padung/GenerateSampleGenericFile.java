/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.padung;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by nhchon on 2/8/2018 10:45 AM.
 */
public class GenerateSampleGenericFile {
    public static void main(String[] args) throws Exception {
        final String csvFile = "C:/Users/nhchon/Pictures/Metabiota/GB-25619/generic_file-56MB.csv";
        File file = new File("C:\\Users\\nhchon\\Pictures\\Metabiota\\GB-25619\\generic_file_distinct_records-56MB.csv");
        //file.createNewFile();

        RandomAccessFile stream = new RandomAccessFile(file, "rw");

        FileChannel channel = stream.getChannel();


        try(BufferedReader in = new BufferedReader(new FileReader(csvFile))) {
            // header line
            String line = in.readLine();
            byte[] strBytes = (line + System.lineSeparator()).getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
            buffer.put(strBytes);
            buffer.flip();
            channel.write(buffer);

            // content
            int index = 1;
            while ((line = in.readLine()) != null) {
                // process line here.
                String[] arr = line.split(",");
                // group
                arr[0] = StringUtils.leftPad(index+"", 7, '0');
                arr[0] = "G-" + arr[0];
                // unit
                arr[1] = index+"";

                StringBuilder b = new StringBuilder();
                b.append(arr[0]);
                b.append(",");
                // Units
                b.append(arr[1]);
                b.append(",");
                // StreetAddress
                b.append(arr[2]);
                b.append(",");
                // City
                b.append(arr[3]);
                b.append(",");
                // State
                b.append(arr[4]);
                b.append(",");
                // Zip
                b.append(arr[5]);
                b.append(",");
                // Country
                b.append(arr[6]);
                b.append(",");
                // Latitude
                b.append(arr[7]);
                b.append(",");
                // Longitude
                b.append(arr[8]);

                String newLine = b.toString();
                strBytes = (newLine + System.lineSeparator()).getBytes();
                buffer = ByteBuffer.allocate(strBytes.length);
                buffer.put(strBytes);
                buffer.flip();
                channel.write(buffer);
                 index++;
            }
        }

        stream.close();
        channel.close();
    }
}
