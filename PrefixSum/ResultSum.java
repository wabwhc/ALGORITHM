package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ResultSum {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        
        st = new StringTokenizer(br.readLine());
        array[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken()) + array[i - 1];
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(array[end - 1] - array[start - 1]);

        }
    
    }
}
