import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[2577번] 숫자의 개수
https://www.acmicpc.net/problem/2577
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(bufferedReader.readLine());
        int B = Integer.parseInt(bufferedReader.readLine());
        int C = Integer.parseInt(bufferedReader.readLine());

        int multi = A * B * C;
        int[] numArr = new int[10];
        while (true) {
            int mod = multi % 10;
            numArr[mod] += 1;

            if (multi / 10 == 0) {
                break;
            }

            multi /= 10;
        }

        for (int num : numArr) {
            System.out.println(num);
        }
    }
}