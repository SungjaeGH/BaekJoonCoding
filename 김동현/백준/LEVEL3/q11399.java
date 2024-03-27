package 김동현.백준.LEVEL3;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class q11399 {
    public static void main(String[] args) throws IOException {
        // 선언 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기

        int N =  Integer.parseInt(bf.readLine());  
        
        String numbers = bf.readLine(); 

        String[] numbersStr = numbers.split(" ");
        int[] numbersArr = new int[numbersStr.length];
        
        int addTime = 0;
        int totalTime = 0;

        for (int i = 0; i < numbersStr.length; i++) {
            numbersArr[i] = Integer.parseInt(numbersStr[i]);
        }
        
        for(int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if(numbersArr[j] <= numbersArr[i]){
                    int tmp = numbersArr[j];
                    numbersArr[j] = numbersArr[i];
                    numbersArr[i] =  tmp;
                }
            }
            addTime = addTime + numbersArr[i] ;
            totalTime = totalTime +  addTime;
        }

        bw.write(totalTime);   //버퍼에 있는 값 전부 출력
        

        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close();   //스트림을 닫음
    }
}