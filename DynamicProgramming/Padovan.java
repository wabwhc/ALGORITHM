package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//9461
public class Padovan {
    static long[] dp = new long[101];
    
    public static void main(String[] args)throws IOException {
        // 규칙이 n-2번째, n-3번째를 더하면 n번째 숫자가 나옴
        dp[1] = 1;
        dp[2] = 1;  
        dp[3] = 1;  
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++){
            System.out.println(dp(Integer.parseInt(br.readLine())));
        }
    }


    static long dp(int k){
        if(dp[k] == 0){
            dp[k] = dp(k - 2) + dp(k - 3);
        }

        return dp[k];
    }
}
