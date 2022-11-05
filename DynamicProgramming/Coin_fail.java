package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin_fail {
    static int n;
    static int k;
    static int[] coinValues;

    //2293
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    
        coinValues = new int[n];
        for(int i = 0; i < n; i++){
            coinValues[i] = Integer.parseInt(br.readLine());
        }
        
        int result = operator(n - 1, 0);
        System.out.println(result);

    }


    // 시간초과
    static int operator(int idx, int sum){
        if(idx < 0){
            return 0;
        }
        
        int count = 0;
        int i = 0;
        
        int value = coinValues[idx];
        int sumCopy = sum;

        while(true){
            sumCopy += value * i;
            if(sumCopy == k){
                count += 1;
                break;
            }else if(sumCopy > k){
                break;
            }

            count += operator(idx - 1, sumCopy);

            i++;
            sumCopy = sum;
        }
        return count;

    }
}
