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

/**
 * Created by nhchon on 9/27/2017 1:47 PM.
 */
import java.util.Scanner;

/**
 *
 * @author vanchung
 */
public class ToHop {
    private int i, n, k, a[];

    public void Init() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Nhập vào số phần tử n >=0:");
            this.n = input.nextInt();
            System.out.print("Nhập vào số tổ hợp  k <= n:");
            this.k = input.nextInt();
        } while (this.n < 0 || this.k > this.n);

        a = new int[n+1];
        for (int j = 1; j <= this.k; j++)
            a[j] = j;
    }

    //Hiển thị kết quả
    public void Result() {
        for (int j = 1; j <= k; j++)
            System.out.print(a[j] + "  ");
        System.out.println();
    }
    //Sinh tổ hợp
    public void sinhToHop() {
        do {
            Result();
            this.i = this.k;
            while (this.i > 0 && a[i] == this.n -this.k + i) -- i;
            if (this.i > 0) {
                a[i]++;
                for (int j = i + 1; j <= this.k; j++) {
                    a[j] = a[j-1] + 1;
                }
            }

        } while (this.i != 0);

    }
    public static void main(String[] agrs) {
        ToHop tohop = new ToHop();
        tohop.Init();
        tohop.sinhToHop();
        System.gc();
    }
}