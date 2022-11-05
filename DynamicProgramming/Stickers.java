package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//9465
public class Stickers {
    static int[][] map;
    static int[][] bottomUp_table;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        //int n = Integer.parseInt(br.readLine());
        
        
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            map = new int[n + 1][2];
            bottomUp_table = new int[n + 1][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n + 1; j++){
                map[j][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n + 1; j++){
                map[j][1] = Integer.parseInt(st.nextToken());
            }
            bottomUp_table[1][0] = map[1][0];
            bottomUp_table[1][1] = map[1][1];
            System.out.println(DP(n));
        }
    }

    static int DP(int n){
        
        for(int i = 2; i < n + 1; i++){
            bottomUp_table[i][0] = Math.max(bottomUp_table[i - 2][1], bottomUp_table[i - 1][1]) + map[i][0];
            bottomUp_table[i][1] = Math.max(bottomUp_table[i - 2][0], bottomUp_table[i - 1][0]) + map[i][1];
        }

        return Math.max(bottomUp_table[n][0], bottomUp_table[n][1]);
    }
}
