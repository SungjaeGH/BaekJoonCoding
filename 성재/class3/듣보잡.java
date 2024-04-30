import java.io.*;
import java.util.*;

/*
[1764번] 듣보잡
https://www.acmicpc.net/problem/1764
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int unknownCount1 = Integer.parseInt(stringTokenizer.nextToken());
        int unknownCount2 = Integer.parseInt(stringTokenizer.nextToken());

        HashMap<String, Integer> unknownGroup1 = new HashMap<>();
        ArrayList<String> resultGroup = new ArrayList<>();

        for (int idx = 0; idx < unknownCount1; idx++) {
            String person = bufferedReader.readLine();

            if (!unknownGroup1.containsKey(person)) {
                unknownGroup1.put(person, idx);
            }
        }

        for (int idx = 0; idx < unknownCount2; idx++) {
            String person = bufferedReader.readLine();
            if (unknownGroup1.containsKey(person)) {
                resultGroup.add(person);
            }
        }

        Collections.sort(resultGroup);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(resultGroup.size()));
        bufferedWriter.write('\n');

        for (String person : resultGroup) {
            bufferedWriter.write(person);
            bufferedWriter.write('\n');
        }

        bufferedWriter.flush();
    }
}