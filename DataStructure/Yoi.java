package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1253
public class Yoi {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());



        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        int count = 0;
        for(int i = 0; i < N; i++){
            int start = 0;
            int end = N - 1;
            int qus = input[i];

            while(true){
                if(end == i){
                    end -= 1;
                }
                if(start == i){
                    start += 1;
                }
                int tmp = input[start] + input[end];
                
                if(end <= start) break;

                if(tmp == qus){
                    count += 1;
                    break;
                }else if(tmp < qus){
                    start += 1;
                }else if(tmp > qus){
                    end -= 1;
                }
            }
        }

        System.out.println(count);
    }
}
