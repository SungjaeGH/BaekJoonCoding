import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
<17219번> 비밀번호 찾기
https://www.acmicpc.net/problem/17219
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
        int storedSiteCount = Integer.parseInt(st.nextToken());
        int findSiteCount = Integer.parseInt(st.nextToken());

        HashMap<String, String> siteInfo = new HashMap<>();

        for (int siteIdx = 0; siteIdx < storedSiteCount; siteIdx++) {
            StringTokenizer siteTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            String siteName = siteTokenizer.nextToken();
            String sitePw = siteTokenizer.nextToken();

            siteInfo.put(siteName, sitePw);
        }

        for (int siteIdx = 0; siteIdx < findSiteCount; siteIdx++) {
            String findSite = bufferedReader.readLine();

            if (siteInfo.containsKey(findSite)) {
                bufferedWriter.write(siteInfo.get(findSite) + '\n');
            }
        }

        bufferedWriter.flush();
    }
}

