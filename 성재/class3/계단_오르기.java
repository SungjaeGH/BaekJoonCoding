import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/*
[2579번] 계단 오르기
https://www.acmicpc.net/problem/2579
 */

public class Main {

    static class Stair {
        private int curr;
        private int continuous;
        private int score;

        public Stair(int curr, int continuous, int score) {
            this.curr = curr;
            this.continuous = continuous;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int stairsCount = Integer.parseInt(bufferedReader.readLine());

        int[] stairs = new int[stairsCount];
        for (int idx = 0; idx < stairsCount; idx++) {
            stairs[idx] = Integer.parseInt(bufferedReader.readLine());
        }

        bfs(stairs);
        dp(stairs);
    }

    /*
        [동적계획법(Bottom-up) 사용]
        -> 이해가 잘 안됨... (다시보기!)
     */
    private static void dp(int[] stairs) {
        int stairCount = stairs.length;
        int[] dpArr = new int[stairCount + 1];

        dpArr[1] = stairs[0];

        if (stairCount > 2) {
            dpArr[2] = stairs[0] + stairs[1];
        }

        for (int idx = 3; idx <= stairCount; idx++) {
            dpArr[idx] = Math.max(dpArr[idx - 2], dpArr[idx - 3] + stairs[idx - 2]) + stairs[idx - 1];
        }

        System.out.println(dpArr[stairCount]);
    }

    /*
        [BFS 사용]
         -> 메모리 초과!!
     */
    private static void bfs(int[] stairs) {
        Queue<Stair> queue = new LinkedList<>();
        int result = 0;
        queue.offer(new Stair(-1, 0, 0));

        while (!queue.isEmpty()) {
            Stair stair = queue.poll();

            if (stair.curr == stairs.length - 1) {
                result = Math.max(result, stair.score);
                continue;
            }

            int firstStair = stair.curr + 1;
            int secondStair = stair.curr + 2;

            if (firstStair < stairs.length && stair.continuous < 2) {
                Stair newStair = new Stair(firstStair, stair.continuous + 1, stair.score + stairs[firstStair]);
                queue.offer(newStair);
            }

            if (secondStair < stairs.length) {
                Stair newStair = new Stair(secondStair, 1, stair.score + stairs[secondStair]);
                queue.offer(newStair);
            }
        }

        System.out.println(result);
    }
}