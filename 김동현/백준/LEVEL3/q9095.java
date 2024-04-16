package 김동현.백준.LEVEL3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class q9095 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int[] arr = new int[12];
            // 1
            arr[1] = 1;
            // 1+1,2
            arr[2] = 2;
            // 1+1+1, 1+2, 2+1, 3
            arr[3] = 4;
            for (int j = 4; j <= t; j++)
                arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
            System.out.println(arr[t]);
        }
    }
}