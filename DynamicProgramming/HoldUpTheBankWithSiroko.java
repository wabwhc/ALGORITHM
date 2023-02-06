package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//26607
//시간초과 아직 못 풀었음

public class HoldUpTheBankWithSiroko {
    static int n;
    static int k;
    static int x;
    static int max = 0;
    static int a = 0;
    static int b = 0;
    static int[][] status;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());


        status = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            status[i][0] = Integer.parseInt(st.nextToken());
            status[i][1] = Integer.parseInt(st.nextToken());
        }

        DP(0, 0);
        System.out.println(max);
    }

    static void DP(int start, int depth){
        if(depth < k){
            for(int i = start; i < n; i++){
                a += status[i][0];
                b += status[i][1];
                DP(i + 1, depth + 1);
                a -= status[i][0];
                b -= status[i][1];
            }
        }else{
            int result = a * b;
            if(max < result){
                max = result;
            }
        }

    }
}
