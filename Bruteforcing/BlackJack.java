package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2798
public class BlackJack {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cardsValue = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cardsValue[i] = Integer.parseInt(st.nextToken());
        }

        int result = search(cardsValue, M);
        System.out.println(result);

    }

    static int search(int[] values, int target){
        int length = values.length;
        int max = 0;
        for(int i = 0; i < length - 2; i++){
            for(int j = i + 1; j < length - 1; j++){
                for(int k = j + 1; k < length; k++){
                    int sum = values[i] + values[j] + values[k];
                    if(sum == target){
                        return sum;
                    }else if(sum < target){
                        if(max < sum){
                            max = sum;
                        }
                    }

                }
            }
        }


        return max;
    }
}
