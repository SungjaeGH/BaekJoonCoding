import java.io.*;

/*
[1157번] 단어 공부
https://www.acmicpc.net/problem/1157
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sentence = bufferedReader.readLine().toUpperCase();

        boolean[] checkArr = new boolean[sentence.length()];
        char[] charArray = sentence.toCharArray();
        int maxCount = 0;
        char maxChar = '?';

        for (int wordIdx = 0; wordIdx < charArray.length; wordIdx++) {
            if (checkArr[wordIdx]) {
                continue;
            }

            char word = charArray[wordIdx];
            int wordCount = 0;

            // 알파벳 개수 count 로직
            for (int idx = wordIdx; idx < charArray.length; idx++) {
                if (checkArr[idx]) {
                    continue;
                }

                if (word == charArray[idx]) {
                    checkArr[idx] = true;
                    wordCount++;
                }
            }

            // 비교 로직
            if (wordCount > maxCount) {
                maxCount = wordCount;
                maxChar = word;

            } else if (wordCount == maxCount) {
                maxChar = '?';
            }
        }

        System.out.println(maxChar);
    }
}