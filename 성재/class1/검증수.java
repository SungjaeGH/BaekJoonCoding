import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[2475번] 검증수
https://www.acmicpc.net/problem/2475
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int verifyNum = 0;
        while (stringTokenizer.hasMoreTokens()) {
            int targetNum = Integer.parseInt(stringTokenizer.nextToken());
            verifyNum += (int) Math.pow(targetNum, 2);
        }

        System.out.println(verifyNum % 10);
    }
}