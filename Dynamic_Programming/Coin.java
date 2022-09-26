package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2293
public class Coin {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        // dp이용해야 시간초과안됨
        int[] dp = new int[k + 1];

        for(int i = 0; i < n; i++){
            int coin = Integer.parseInt(br.readLine());
            for(int j = 1; j <= k; j++){
                if(j > coin){
                    dp[j] += dp[j - coin];
                }else if(j == coin){
                    dp[j]++;
                }
            }
        }
        System.out.println(dp[k]);


    }
}
