package DynamicProgramming;

import java.util.Scanner;

//14916
public class Change {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] dp = new int[n + 1];
        try{
            dp[2] = 1;
            dp[4] = 2;
            dp[5] = 1;
        }catch (Exception e){

        }

        for(int i = 6; i < n + 1; i++){
            int NumOf2 = dp[i - 2] != 0 ? dp[i - 2] + 1 : 0;
            int NumOf5 = dp[i - 5] != 0 ? dp[i - 5] + 1 : 0;

            if(NumOf2 == 0 && NumOf5 == 0){
                dp[i] = 0;
            }else if(NumOf2 == 0){
                dp[i] = NumOf5;
            }else if(NumOf5 == 0){
                dp[i] = NumOf2;
            }else{
                dp[i] = Math.min(NumOf2, NumOf5);
            }
        }

        if(dp[n] == 0){
            System.out.println(-1);
        }else{
            System.out.println(dp[n]);
        }

    }
}
