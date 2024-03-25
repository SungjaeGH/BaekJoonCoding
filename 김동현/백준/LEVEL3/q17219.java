package 김동현.백준.LEVEL3;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class q17219 {
    public static void main(String[] args) throws IOException {
        // 선언 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기

        String str = bf.readLine(); 
        
        
        //Space를 경계로 끊어야 할 때 
        String arr[] = str.split(" ");

        //int i =  Integer.parseInt(bf.readLine()); 

        //총 사이트 개수와 찾아야할 사이트 개수 입력
        int N = Integer.parseInt(arr[0]); 
        int M = Integer.parseInt(arr[1]); 

        //hashMap 사이트를 저장할 해쉬 맵
        HashMap<String, String> siteMap = new HashMap<String, String>( );
        
        for(int i = 0; i < N; i++) {
            String site = bf.readLine();
            String siteArr[] = site.split(" ");

            siteMap.put(siteArr[0], siteArr[1]);
        }

        for (int i = 0; i < M; i++) {
            String site = bf.readLine();
            bw.write(siteMap.get(site)+"\n");   //버퍼에 있는 값 전부 출력
        }

        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close();   //스트림을 닫음
    }
}