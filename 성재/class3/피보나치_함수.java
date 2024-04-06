import java.io.*;

/*
<1003번> 피보나치 함수
https://www.acmicpc.net/problem/1003
=> 전형적인 DP 문제!
=> 이미 계산한 값을 다시 계산하지 않도록 배열에 저장해놓고 해당 값을 불러오는 방식
 */

public class Main {
    // 계산된 값을 미리 저장할 배열
    static Integer[][] dp = new Integer[41][2];

    static Integer[] fibonacci(int testNum) {
        // 계산되지 않은 값에 대한 처리
        if (dp[testNum][0] == null || dp[testNum][1] == null) {
            dp[testNum][0] = fibonacci(testNum - 1)[0] + fibonacci(testNum - 2)[0];
            dp[testNum][1] = fibonacci(testNum - 1)[1] + fibonacci(testNum - 2)[1];
        }

        return dp[testNum];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        dp[0][0] = 1; // N = 0일 때의 0 호출 횟수
        dp[0][1] = 0; // N = 0일 때의 1 호출 횟수
        dp[1][0] = 0; // N = 1일 때의 0 호출 횟수
        dp[1][1] = 1; // N = 1일 때의 1 호출 횟수

        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int testNum = Integer.parseInt(bufferedReader.readLine());

            fibonacci(testNum);

            bufferedWriter.write(dp[testNum][0] + " " + dp[testNum][1] + '\n');
        }

        bufferedWriter.flush();
    }
}