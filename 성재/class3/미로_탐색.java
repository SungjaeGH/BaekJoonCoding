import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[2178번] 미로 탐색
https://www.acmicpc.net/problem/2178
-> 최단거리 검색 시, BFS 사용하자!
 */

public class Main {
    static class Location {
        private int row;
        private int col;
        private int distance;

        public Location(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] map = setMap(N, M, bufferedReader);

        int result = bfs(N, M, map);
        System.out.println(result);
    }

    private static boolean[][] setMap(int N, int M, BufferedReader bufferedReader) throws IOException {
        boolean[][] map = new boolean[N][M];

        for (int row = 0; row < N; row++) {
            String colString = bufferedReader.readLine();
            char[] charArray = colString.toCharArray();
            for (int col = 0; col < charArray.length; col++) {
                if (charArray[col] == '1') {
                    map[row][col] = true;
                }
            }
        }

        return map;
    }

    private static int bfs(int N, int M, boolean[][] map) {
        boolean[][] visited = new boolean[N][M];
        Queue<Location> queue = new LinkedList<>();
        int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // 상하좌우
        int result = 0;

        Location init = new Location(0, 0, 1);
        queue.offer(init);
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Location currLoc = queue.poll();

            if ((currLoc.row == N - 1) && (currLoc.col == M - 1)) {
                result = currLoc.distance;
                break;
            }

            for (int idx = 0; idx < move.length; idx++) {
                int nextRow = currLoc.row + move[idx][0];
                int nextCol = currLoc.col + move[idx][1];

                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                    continue;
                }

                if (!visited[nextRow][nextCol] && map[nextRow][nextCol]) {
                    queue.offer(new Location(nextRow, nextCol, currLoc.distance + 1));
                }

                visited[nextRow][nextCol] = true;
            }
        }

        return result;
    }
}
