import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[2884번] 알람 시계
https://www.acmicpc.net/problem/2884
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int min = Integer.parseInt(stringTokenizer.nextToken());
        int sec = Integer.parseInt(stringTokenizer.nextToken());

        int newMin = 0, newSec = 0;
        if (sec < 45) {
            if (min == 0) {
                newMin = (min - 1) + 24;
            } else {
                newMin = min - 1;
            }

            newSec = (sec - 45) + 60;

        } else {
            newMin = min;
            newSec = sec - 45;
        }

        System.out.println(newMin + " " + newSec);
    }
}