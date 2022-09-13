package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2231
public class DecompsitionSum {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean isPossible = false;
        for(int i = 1; i <= N; i++){
            int caseValue = i;
            int copyCaseValue = caseValue;
            
            while(copyCaseValue != 0){
                caseValue += copyCaseValue % 10;
                copyCaseValue /= 10;
            }
            if(caseValue == N){
                isPossible = true;
                System.out.println(i);
                break;
            }
        }
        if(!isPossible){
            System.out.println(0);
        }
    }    
}
