package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2780
public class Password {
    static int[][] dp;
    static int[][] map = new int[][]{{7, -1, -1, -1, -1}, { 2, 4, -1, -1 }, {1, 3, 5, -1}, {2, 6, -1, -1}, {1, 5, 7, -1}, {2, 4, 6, 8}, {3, 5, 9, -1}, {4, 8, 0, -1}, {5, 7, 9, -1}, {6, 8, -1, -1}};
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[10][1001];
        
        for(int i = 0; i < 10; i++){
            dp[i][1] = 1;
        }

        for(int i = 0; i < T; i++){
            int input = Integer.parseInt(br.readLine());
            int result = 0;
            for(int j = 0; j < 10; j++){
                result += DP(j, input);
            }
            System.out.println(result % 1234567);
        }
    }

    static int DP(int number, int seq){
        if(dp[number][seq] != 0){
            return dp[number][seq];
        }else{
            int result = 0;
            for(int i = 0; i < 4; i++){
                int next = map[number][i];
                if(next != -1){
                    result += DP(next, seq - 1);
                }
            }
            dp[number][seq] = result % 1234567;
            return result;
        }
    }
}
