package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//15649
public class NandM {
    static int N;
    static int M;
    static boolean[] visit;
    static int count = 0;
    static int[] set;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        set = new int[M];
        for(int i = 1; i < N + 1; i++){
            BackTracking(i);
        }
    }

    static void BackTracking(int start){
        visit[start] = true;
        set[count] = start;
        count += 1;
        if(count != M){
            for(int i = 1; i < N + 1; i++){
                if(!visit[i]){
                    BackTracking(i);
                }
            }
        }else{
            for(int i = 0; i < M; i++){
                System.out.print(set[i] + " ");
            }
            System.out.println();
        }

        count -= 1;
        visit[start] = false;
        
    }
}
