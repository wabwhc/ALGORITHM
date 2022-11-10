package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1965
public class PutTheBox {
    static int n;
    static int[] SizeOfBox;
    static int[] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        SizeOfBox = new int[n];
        dp = new int[n];
        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            SizeOfBox[i] = Integer.parseInt(st.nextToken());
        }


        int max = 0;
        
        for(int i = n - 2; i >= 0; i--){
            int iSize = SizeOfBox[i];
            for(int j = i + 1; j < n; j++){
                if(iSize < SizeOfBox[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] > max){
                        max = dp[i];
                    }
                }
            }
        }
        
        System.out.println(max == 0 ? 1 : max);
    }
}
