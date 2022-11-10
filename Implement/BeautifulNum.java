package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2774
public class BeautifulNum {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[] numbers;

        for(int i = 0; i < T; i++){
            int input = Integer.parseInt(br.readLine());
            numbers = new boolean[10];
            int count = 0;
            while(input != 0){
                if(!numbers[input % 10]){
                    count += 1;
                    numbers[input % 10] = true;
                }
                input /= 10;
            }
            System.out.println(count);
        }
    }
}
