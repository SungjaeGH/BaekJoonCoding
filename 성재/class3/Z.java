import java.io.*;
import java.util.StringTokenizer;

/*
[1074번] Z
https://www.acmicpc.net/problem/1074
 */

public class Main {
    static int count = 0;

    static void find(int r, int c, int size) {
        if (size == 1) {
            System.out.println(count);
            return;
        }

        int halfSize = size / 2;

        if (r < halfSize && c < halfSize) {
            // 1사분면
            count += (halfSize * halfSize * 0);
            find(r, c, halfSize);

        } else if (r < halfSize && c < size) {
            // 2사분면
            count += (halfSize * halfSize * 1);
            find(r, c - halfSize, halfSize);

        } else if (r < size && c < halfSize) {
            // 3사분면
            count += (halfSize * halfSize * 2);
            find(r - halfSize, c, halfSize);

        } else if (r < size && c < size){
            // 4사분면
            count += (halfSize * halfSize * 3);
            find(r - halfSize, c - halfSize, halfSize);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine() + " ");

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        int size = (int) Math.pow(2, N);

        find(r, c, size);
    }
}