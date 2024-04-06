import java.io.*;
import java.util.StringTokenizer;

/*
[1012번] 유기농 배추
https://www.acmicpc.net/problem/1012
 */

public class Main {
    static int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // 상하좌우

    static void dfs(int currRow, int currCol, boolean[][] map, boolean[][] visited) {
        visited[currRow][currCol] = true;

        for (int idx = 0; idx < 4; idx++) {
            int nextRow = currRow + move[idx][0];
            int nextCol = currCol + move[idx][1];

            if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length) {
                continue;
            }

            if (map[nextRow][nextCol] && !visited[nextRow][nextCol]) {
                dfs(nextRow, nextCol, map, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        for (int testCaseIdx = 0; testCaseIdx < testCaseCount; testCaseIdx++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
            int maxWidth = Integer.parseInt(st.nextToken());
            int maxHeight = Integer.parseInt(st.nextToken());
            int cabbageCount = Integer.parseInt(st.nextToken());
            int wormCount = 0;

            boolean[][] visited = new boolean[maxWidth][maxHeight];
            boolean[][] map = new boolean[maxWidth][maxHeight];

            // map 세팅 (배추 있을 경우 true)
            for (int cabbageIdx = 0; cabbageIdx < cabbageCount; cabbageIdx++) {
                StringTokenizer locationSt = new StringTokenizer(bufferedReader.readLine(), " ");
                int width = Integer.parseInt(locationSt.nextToken());
                int height = Integer.parseInt(locationSt.nextToken());

                map[width][height] = true;
            }

            for (int row = 0; row < maxWidth; row++) {
                for (int col = 0; col < maxHeight; col++) {
                    // 배추가 존재하는 땅일 경우 + 방문하지 않았을 경우
                    if (map[row][col] && !visited[row][col]) {
                        dfs(row, col, map, visited);

                        // 한 영역에 지렁이 한마리만 있어도 해충 피해 X
                        wormCount++;
                    }
                }
            }

            System.out.println(wormCount);
        }
    }
}