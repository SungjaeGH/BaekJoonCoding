import java.io.*;
import java.util.StringTokenizer;

/*
[2630번] 색종이 만들기
https://www.acmicpc.net/problem/2630
 */

public class Main {
    static boolean[][] colorMap;
    static int N = 0;
    static int whiteCount = 0;
    static int blueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        setColorMap(bufferedReader);

        checkColors(0, 0, N);

        System.out.println(whiteCount + " " + blueCount);
    }

    private static void checkColors(int startRow, int startCol, int length) {
        boolean isAllSame = true;
        boolean isBlue = colorMap[startRow][startCol];

        // row, col 범위 내에 색종이 색깔이 동일한지 확인
        for (int row = startRow; row < startRow + length; row++) {
            for (int col = startCol; col < startCol + length; col++) {
                if (colorMap[row][col] != isBlue) {
                    isAllSame = false;
                    break;
                }
            }

            if (!isAllSame) {
                break;
            }
        }

        // 동일할 경우, 색종이 색깔 count
        if (isAllSame) {
            if (isBlue) {
                blueCount++;
            } else {
                whiteCount++;
            }

        } else {
            int newLength = length / 2;

            // 1사분면
            checkColors(startRow, startCol, newLength);
            // 2사분면
            checkColors(startRow, startCol + newLength, newLength);
            // 3사분면
            checkColors(startRow + newLength, startCol, newLength);
            // 4사분면
            checkColors(startRow + newLength, startCol + newLength, newLength);
        }
    }

    private static void setColorMap(BufferedReader bufferedReader) throws IOException {
        colorMap = new boolean[N][N];

        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");

            int col = 0;
            while (st.hasMoreTokens()) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    // 파란색
                    colorMap[row][col] = true;
                }

                col++;
            }
        }
    }
}