import java.io.*;

/*
[10809번] 알파벳 찾기
https://www.acmicpc.net/problem/10809
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();
        char[] charArray = word.toCharArray();
        int[] existAlphaArr = new int[26];

        for (int idx = 0; idx < charArray.length; idx++) {
            int alphaIdx = charArray[idx] - 'a';
            if (existAlphaArr[alphaIdx] == 0) {
                existAlphaArr[alphaIdx] = idx + 1;
            }
        }

        for (int alphaIdx : existAlphaArr) {
            if (alphaIdx != 0) {
                bufferedWriter.write((alphaIdx - 1) + " ");

            } else {
                bufferedWriter.write("-1 ");

            }
        }

        bufferedWriter.flush();
    }
}