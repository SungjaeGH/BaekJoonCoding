import java.io.*;
import java.util.StringTokenizer;

/*
[1152번] 단어의 개수
https://www.acmicpc.net/problem/1152
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        int countTokens = stringTokenizer.countTokens();

        System.out.println(countTokens);
    }
}