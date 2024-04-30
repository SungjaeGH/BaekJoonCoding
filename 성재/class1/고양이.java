import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
[10171번] 고양이
https://www.acmicpc.net/problem/10171
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        bufferedWriter.write("\\    /\\");
        bufferedWriter.write("\n");
        bufferedWriter.write(" )  ( ')");
        bufferedWriter.write("\n");
        bufferedWriter.write("(  /  )");
        bufferedWriter.write("\n");
        bufferedWriter.write(" \\(__)|");

        bufferedWriter.flush();
    }
}