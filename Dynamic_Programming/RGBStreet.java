package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1149
public class RGBStreet {
    static int[][] bottomUp_table;
    static int[][] map;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        map = new int[N][3];
        bottomUp_table = new int[N][3];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 3; i++){
            bottomUp_table[0][i] = map[0][i];
        }
        System.out.println( bottomUp(N - 1));
    }

    static int bottomUp(int N){
        if(N == 0){
            return Math.min(bottomUp_table[0][0],  Math.min(bottomUp_table[0][1], bottomUp_table[0][2]));
        }

        for(int i = 1; i <= N; i++){
            bottomUp_table[i][0] =  Math.min(bottomUp_table[i - 1][1], bottomUp_table[i - 1][2]) + map[i][0];
            bottomUp_table[i][1] =  Math.min(bottomUp_table[i - 1][0], bottomUp_table[i - 1][2]) + map[i][1];
            bottomUp_table[i][2] =  Math.min(bottomUp_table[i - 1][1], bottomUp_table[i - 1][0]) + map[i][2];
        }

        return Math.min(bottomUp_table[N][0],  Math.min(bottomUp_table[N][1], bottomUp_table[N][2]));
    }
}
