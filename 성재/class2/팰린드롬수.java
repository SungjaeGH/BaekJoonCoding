import java.io.*;
import java.util.ArrayList;

/*
[1259번] 팰린드롬수
https://www.acmicpc.net/problem/1259
-> 문자열 뒤집기할 때는 StringBuilder를 사용하자!
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isInputEnd = false;

        ArrayList<StringBuilder> numArr = new ArrayList<>();
        ArrayList<String> resultArr = new ArrayList<>();

        while (!isInputEnd) {
            String inputNum = bufferedReader.readLine();
            if (!inputNum.equals("0")) {
                numArr.add(new StringBuilder(inputNum));

            } else {
                isInputEnd = true;
            }
        }

        for (StringBuilder num : numArr) {
            if (num.toString().contentEquals(num.reverse())) {
                resultArr.add("yes");
            } else {
                resultArr.add("no");
            }
        }

        for (String result : resultArr) {
            System.out.println(result);
        }

    }
}