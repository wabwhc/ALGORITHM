package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2839
public class SugarDelivery {
    //가장 큰수로 나눔
    // 나머지 작은수로 나눔
    //안되면 가장큰수로 덜? 나눔
    // 나머지 작은수로 나눔
    //반복
    static int kilo5 = 5;
    static int kilo3 = 3;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());
        int result = Greedy(sugar);
        System.out.println(result);
    }
    static int Greedy(int sugar){
        int sum = sugar / kilo5;
        int remainder = sugar % kilo5;
        if(remainder % kilo3 == 0){
            sum += remainder / 3;
            return sum;
        }else{
            for(int i = 0; i < sugar / kilo5; i++){
                sum -= 1;
                remainder += 5;
                if(remainder % kilo3 == 0){
                    sum += remainder / 3;
                    return sum;
                }
            }
            return -1;
        }
    }
}
