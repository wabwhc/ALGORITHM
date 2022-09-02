package Prefix_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//11659
public class SumOfInterval4 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

     
        //이렇게 하면 시간이 초과된다


        //int[] array = new int[N];
        //st = new StringTokenizer(br.readLine());
        //for(int i = 0; i < N; i++){
        //    array[i] = Integer.parseInt(st.nextToken());
        //}
        //for(int i = 0; i < M; i++){
        //    st = new StringTokenizer(br.readLine());
        //    int start = Integer.parseInt(st.nextToken());
        //    int end = Integer.parseInt(st.nextToken());
        //    int sum = 0;
        //    for(int j = 0; j <= end - start; j++){
        //        sum += array[start - 1 + j];
        //    }
        //    System.out.println(sum);
        //}

        int[] array = new int[N + 1];
        array[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            array[i] = Integer.parseInt(st.nextToken()) + array[i - 1];
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(array[end] - array[start - 1]);
            
        }
    }
}
