import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[2920번] 음계
https://www.acmicpc.net/problem/2920
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        boolean isAsc = true, isDes = true, isMixed = false;
        int firstAscNum = 1, firstDesNum = stringTokenizer.countTokens();
        while (stringTokenizer.hasMoreTokens()) {
            int currNum = Integer.parseInt(stringTokenizer.nextToken());

            if (isAsc && (currNum == firstAscNum)) {
                firstAscNum++;
                isDes = false;

            } else if (isDes && (currNum == firstDesNum)) {
                firstDesNum--;
                isAsc = false;

            } else {
                isAsc = false;
                isDes = false;
                isMixed = true;
                break;
            }
        }

        String result;
        if (isAsc) {
            result = "ascending";

        } else if (isDes) {
            result = "descending";

        } else {
            result = "mixed";
        }

        System.out.println(result);
    }
}
