package Combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//15489
public class PascalTriangle {
    static int[][] pascal = new int[31][31];
    static int R;
    static int C;
    static int W;
    static int sum = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        StringTokenizer st = new StringTokenizer(br.readLine());

        //배열 만듬
        for(int i = 1; i <= 30; i++){
            for(int j = 1; j <= i; j++){
                if(j == 1 || j == i){
                    pascal[i][j] = 1;
                }else{
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                }
            }
        }


        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < W; i++){
            for(int j = 0; j < i + 1; j++){
                sum += pascal[R + i][C + j];
            }
        }

        System.out.println(sum);
    }
}
