package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LossOfMuscle {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        int[] weightGain = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            weightGain[i] = Integer.parseInt(st.nextToken()) - K;
        }

        boolean isPossible = SumIsPlus(weightGain);
        if(isPossible){
            boolean[] visit = new boolean[N];
            System.out.println(DFS(visit, weightGain, 0, 0));

        }else{
            System.out.println(0);
        }
    }


    //-면 false +면 true
    static boolean SumIsPlus(int[] array){
        int length = array.length;
        int sum = 0;

        for(int i = 0; i < length; i++){
            sum += array[i];
        }

        if(sum < 0){
            return false;
        }

        return true;
    }

    static int DFS(boolean[] visit, int[] array, int depth, int sum){
        int length = array.length;
        int count = 0;

        if(depth == length){
            return 1;
        }

        for(int i = 0; i < length; i++){
            //if(!visit[i]){
            //    visit[i] = true;
            //    sum += array[i];
            //    if(sum >= 0){
            //        count += DFS(visit, array, depth + 1, sum);
            //    }
            //    sum -= array[i];
            //    visit[i] = false;
            //}
            if(!visit[i] && sum + array[i] >= 0){
                visit[i] = true;
                count += DFS(visit, array, depth + 1, sum + array[i]);
                visit[i] = false;
            }
        }

        return count;
    }
}
