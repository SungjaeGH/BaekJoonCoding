import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/*
[1181번] 단어 정렬
https://www.acmicpc.net/problem/1181
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int wordCount = Integer.parseInt(bufferedReader.readLine());
        TreeMap<Integer, ArrayList<String>> treeMap = new TreeMap<>();

        for (int wordIdx = 0; wordIdx < wordCount; wordIdx++) {
            String word = bufferedReader.readLine();
            Integer wordLen = word.length();

            if (treeMap.containsKey(wordLen)) {
                ArrayList<String> wordList = treeMap.get(wordLen);
                if (!wordList.contains(word)) {
                    wordList.add(word);
                    Collections.sort(wordList);
                }

            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(word);
                treeMap.put(wordLen, newList);
            }
        }

        for (ArrayList<String> targetList : treeMap.values()) {
            for (String word : targetList) {
                bufferedWriter.write(word);
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.flush();
    }
}