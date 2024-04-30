import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
[1463번] 1로 만들기
https://www.acmicpc.net/problem/1463
 */
public class Main {
    static class Calculation {
        private final int targetNum;
        private final int count;

        public Calculation(int targetNum, int count) {
            this.targetNum = targetNum;
            this.count = count;
        }
    }

    private static int bfs(int targetNum) {
        Queue<Calculation> queue = new LinkedList<>();
        int result = 0;

        queue.offer(new Calculation(targetNum, 0));

        while (!queue.isEmpty()) {
            Calculation currCal = queue.poll();
            int currNum = currCal.targetNum;
            int currCount = currCal.count;

            if (currNum == 1) {
                result = currCount;
                break;
            }

            if (currNum % 3 == 0) {
                queue.offer(new Calculation(currNum / 3, currCount + 1));
            }

            if (currNum % 2 == 0) {
                queue.offer(new Calculation(currNum / 2, currCount + 1));
            }

            queue.offer(new Calculation(currNum - 1, currCount + 1));
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int targetNum = Integer.parseInt(bufferedReader.readLine());

        int count = bfs(targetNum);

        System.out.println(count);
    }
}
