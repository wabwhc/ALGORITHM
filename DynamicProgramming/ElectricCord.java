package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ElectricCord {
    static int NumOfCord;
    static int[][] cord;
    static int[] dp;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        NumOfCord = Integer.parseInt(br.readLine());
        cord = new int[NumOfCord][2];
        dp = new int[NumOfCord];

        for(int i = 0; i < NumOfCord; i++){
            st = new StringTokenizer(br.readLine());    
            cord[i][0] = Integer.parseInt(st.nextToken());
            cord[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cord, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        int result = DP();
        System.out.println(NumOfCord - result);

    }


    static int DP(){
        int max = 0;
        for(int i = 0; i < NumOfCord; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(cord[i][1] > cord[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
