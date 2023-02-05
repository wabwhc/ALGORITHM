package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//10815
public class NumberCard {
    static int[] hold;
    static int N;
    static int M;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        hold = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            hold[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(hold);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int num;
        for(int i = 0; i < M; i++){
            num = Integer.parseInt(st.nextToken());

            if(binarySearch(num)){
                System.out.print("1 ");
            }else{
                System.out.print("0 ");
            }

        }


    }

    static boolean binarySearch(int num){
        int left = 0;
        int right = N - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            int midNum = hold[mid];

            if(num > midNum){
                left = mid + 1;
            }else if(num < midNum){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
