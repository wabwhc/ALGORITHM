package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//1920
//이진탐색 기본 문제
public class FindNumber {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            System.out.println(binarySearch(array, Integer.parseInt(st.nextToken())));
        }

    }

    static int binarySearch(int[] array, int quest){
        int start = 0;
        int last = array.length - 1;

        while(start <= last){
            int mid = (start + last) / 2;
            if(array[mid] == quest){
                return 1;
            }else if(array[mid] > quest){
                last = mid - 1;

            }else if(array[mid] < quest){
                start = mid + 1;
            }
        }

        return 0;
    }
}
