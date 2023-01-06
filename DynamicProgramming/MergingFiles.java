package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//11066
public class MergingFiles {
    static int k;
    static int[] inputs;
    static int[][] dp;
    static int[] sum;
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            k = Integer.parseInt(br.readLine());
            inputs = new int[k + 1];
            sum = new int[k + 1];
            dp = new int[k + 1][k + 1];

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < k + 1; j++){
                inputs[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j - 1] + inputs[j];
            }


            //dp부분
            for(int n = 1; n < k + 1; n++){
                for(int from = 1; from + n < k + 1; from++){
                    int to = from + n;
                    dp[from][to] = Integer.MAX_VALUE;

                    for(int middle = from; middle < to; middle++){
                        dp[from][to] = Math.min(dp[from][to], dp[from][middle] + dp[middle + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }

            System.out.println(dp[1][k]);
            

        }
    }
}
