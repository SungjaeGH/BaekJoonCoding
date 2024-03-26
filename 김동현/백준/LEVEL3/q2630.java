package 김동현.백준.LEVEL3;

import java.util.Scanner;

public class q2630 {
    public static int white = 0;
    public static int blue = 0;
    public static int[][] board;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        board = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = in.nextInt();

        section(0, 0, N);
    }

    public static void section(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (board[row][col] == 0) white++;
            else blue++;
            return;
        }

        int newSize = size / 2;
        for (int i = row; i < row + size; i += newSize) {
            for (int j = col; j < col + size; j += newSize) {
                section(i, j, newSize);
            }
        }
    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) return false;
            }
        }
        return true;
    }
}
