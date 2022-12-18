package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1049
public class GuitarStrings {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int NumOfStrings = Integer.parseInt(st.nextToken());
        int NumOfMakers = Integer.parseInt(st.nextToken());

        int PriceOfSet = 2147483647;
        int PriceOfEach = 2147483647;

        for(int i = 0; i < NumOfMakers; i++){
            st = new StringTokenizer(br.readLine());
            int inputSet = Integer.parseInt(st.nextToken());
            int inputEach = Integer.parseInt(st.nextToken());
            if(inputEach < PriceOfEach){
                PriceOfEach = inputEach;
            }

            if(inputSet < PriceOfSet){
                PriceOfSet = inputSet;
            }
        }
        
        if(PriceOfEach != 0){
            int point = PriceOfSet / PriceOfEach;
            if(point < 6){
                int NumOfBuySet = 0;
                int NumOfBuyEach = 0;
        
                NumOfBuySet = NumOfStrings / 6;
                NumOfBuyEach = NumOfStrings % 6;
            
                if(NumOfBuyEach > point){
                    NumOfBuySet += 1;
                    NumOfBuyEach = 0;
                }
            
                int result = NumOfBuySet * PriceOfSet + NumOfBuyEach * PriceOfEach;
                System.out.println(result);    
            }else{
                int result = NumOfStrings * PriceOfEach;
                System.out.println(result);
            }
        }else{
            System.out.println(0);
        }
    }
}
