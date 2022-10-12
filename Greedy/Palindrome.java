package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1213
public class Palindrome {
    static int[] NumOfAlphabet = new int[26];
    static int NumOfOdd = 0;
    static String result = "";
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        for(int i = 0; i < input.length(); i++){
            int idx = input.charAt(i) - 'A';
            NumOfAlphabet[idx] += 1;
        }

        
        for(int i = 0; i < 26; i++){
            if(NumOfAlphabet[i] % 2 == 1){
                NumOfOdd += 1;
                //홀수개인 알파벳이 2개 이상이면 불가능
                if(NumOfOdd > 1){
                    break;
                }
            }
        }


        if(NumOfOdd > 1){
            System.out.println("I'm Sorry Hansoo");
        }else{
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < NumOfAlphabet[i] / 2; j++){
                    sb.append((char)(i + 65));
                }
            }
            result += sb.toString();
            for(int i = 0; i < 26; i++){
                if(NumOfAlphabet[i] % 2 == 1){
                    result += (char)(i + 65);
                }
            }
    
            result += sb.reverse().toString();
            System.out.println(result);
        }
    }
}
