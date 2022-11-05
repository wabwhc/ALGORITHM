package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bag {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
    
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        int W = 0;
        int V = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            // --로 해야함
            // ++로 하면 같은 물건이 중복됨
            for(int j = K; j >= W; j--){
                dp[j] = Math.max(V + dp[j - W], dp[j]);
            }

        }

        System.out.println(dp[K]);

    }
}
