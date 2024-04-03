import java.io.*;

/*
[8958번] OX퀴즈
https://www.acmicpc.net/problem/8958
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            String quizResult = bufferedReader.readLine();
            char[] quizArr = quizResult.toCharArray();

            int score = 0, continueCorrect = 0;
            for (char result : quizArr) {
                if (continueCorrect != 0) {
                    if (result == 'O') {
                        score += (1 + continueCorrect);
                        continueCorrect++;

                    } else {
                        continueCorrect = 0;
                    }

                } else {
                    if (result == 'O') {
                        score++;
                        continueCorrect++;
                    }
                }
            }

            bufferedWriter.write(score + "\n");
        }

        bufferedWriter.flush();
    }
}