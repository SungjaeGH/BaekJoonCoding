import java.io.*;
import java.util.StringTokenizer;

/*
<2675번 문자열 반복>
https://www.acmicpc.net/problem/2675
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcaseCount = Integer.parseInt(bufferedReader.readLine());
        int[] repeatCountArr = new int[testcaseCount];
        String[] sentence = new String[testcaseCount];

        for (int testcase = 0; testcase < testcaseCount; testcase++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            repeatCountArr[testcase] = Integer.parseInt(stringTokenizer.nextToken());
            sentence[testcase] = stringTokenizer.nextToken();
        }

        for (int testcase = 0; testcase < testcaseCount; testcase++) {
            char[] wordArr = sentence[testcase].toCharArray();
            StringBuilder stringBuilder = new StringBuilder();

            for (char word : wordArr) {
                for (int idx = 0; idx < repeatCountArr[testcase]; idx++) {
                    stringBuilder.append(word);
                }
            }

            bufferedWriter.write(stringBuilder.toString());
            if (testcase != testcaseCount - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.flush();
    }
}