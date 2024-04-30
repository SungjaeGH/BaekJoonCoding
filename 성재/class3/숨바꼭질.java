import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[1697번] 숨바꼭질
https://www.acmicpc.net/problem/1697
 */

public class Main {
    static class Point {
        private final int currLoc;
        private final int time;

        public Point(int currLoc, int time) {
            this.currLoc = currLoc;
            this.time = time;
        }
    }

    private static int bfs(int N, int K) {
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int result = 0;

        Point init = new Point(N, 0);
        queue.offer(init);
        visited[N] = true;

        while (!queue.isEmpty()) {
            Point currPoint = queue.poll();

            if (currPoint.currLoc == K) {
                result = currPoint.time;
                break;
            }

            for (int idx = 0; idx < 3; idx++) {
                int nextLoc = switch (idx) {
                    case 0 -> currPoint.currLoc + 1;
                    case 1 -> currPoint.currLoc - 1;
                    case 2 -> currPoint.currLoc * 2;
                    default -> 0;
                };

                if ((nextLoc >= 0) && (nextLoc <= 100000) && (!visited[nextLoc])) {
                    visited[nextLoc] = true;
                    queue.offer(new Point(nextLoc, currPoint.time + 1));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(bfs(N, K));
    }
}