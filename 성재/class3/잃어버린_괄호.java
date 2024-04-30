import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[1541번] 잃어버린 괄호
https://www.acmicpc.net/problem/1541

!! 그리드 알고리즘 (탐욕법) 사용한 예제
=> 최적해를 구하는 문제 (당장 눈에 보이는 최적의 방법을 선택하는 법)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String calculation = bufferedReader.readLine();

        StringTokenizer stringTokenizer = new StringTokenizer(calculation, "+,-", true);

        int plusNum = 0, minusNum = 0;
        boolean isMinus = false;
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();

            if (token.equals("-")) {
                isMinus = true;

            } else if (token.equals("+")) {
                continue;

            } else {
                int num = Integer.parseInt(token);

                if (isMinus) {
                    minusNum += num;

                } else {
                    plusNum += num;
                }
            }
        }

        System.out.println(plusNum - minusNum);
    }
}