import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[10250번] ACM 호텔
https://www.acmicpc.net/problem/10250
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(bufferedReader.readLine());

        for (int testIdx = 0; testIdx < testCount; testIdx++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            int H = Integer.parseInt(stringTokenizer.nextToken());
            int W = Integer.parseInt(stringTokenizer.nextToken());
            int N = Integer.parseInt(stringTokenizer.nextToken());


            int newH = N % H;
            if (newH == 0) {
                newH = H;
            }

            int newW = N / H;
            if (N % H != 0) {
                newW += 1;
            }

            System.out.printf("%d%02d\n", newH, newW);
        }
    }
}