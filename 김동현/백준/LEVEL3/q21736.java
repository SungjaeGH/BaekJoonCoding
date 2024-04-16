package 김동현.백준.LEVEL3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q21736 {
    static int n, m, cnt = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        int dx = 0, dy = 0; // 도연이의 위치

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'I') {
                    dx = i;
                    dy = j;
                }
            }
        }

        bfs(dx, dy);

        if (cnt != 0) {
            System.out.println(cnt);
        } else {
            System.out.println("TT");
        }
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dr[i];
                int ny = pos.y + dc[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 'X') {
                    continue;
                }

                if (map[nx][ny] == 'P') {
                    cnt++;
                }

                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
    }
}