import java.io.*;
import java.util.PriorityQueue;

/*
[1927번] 최소힙
https://www.acmicpc.net/problem/1927
-> Heap과 관련된 문제일 경우에는 PriorityQueue를 사용하자!
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputCount = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int idx = 0; idx < inputCount; idx++) {
            int inputNum = Integer.parseInt(bufferedReader.readLine());

            if (inputNum != 0) {
                minHeap.offer(inputNum);

            } else {
                if (minHeap.isEmpty()) {
                    bufferedWriter.write(String.valueOf(0));
                    bufferedWriter.write("\n");

                } else {
                    int min = minHeap.poll();
                    bufferedWriter.write(String.valueOf(min));
                    bufferedWriter.write("\n");
                }
            }
        }

        bufferedWriter.flush();
    }
}