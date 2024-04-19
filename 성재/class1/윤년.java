import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[2753번] 윤년
https://www.acmicpc.net/problem/2753
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(bufferedReader.readLine());

        boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
        System.out.println(isLeapYear ? 1 : 0);
    }
}