package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//1436
public class TitleOfMovie {
    final static int NumOfEnding = 666;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        System.out.println(force(input));
    }

    static int force(int idx){
        int count = 1;
        int num = NumOfEnding;
        while(count != idx){
            num++;
	        if(String.valueOf(num).contains("666")) { 
	        	count++;
	        }
        }
        return num;
    }
}
