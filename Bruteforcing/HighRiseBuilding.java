package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//1027
public class HighRiseBuilding {
    static int N = 0;
    static int[] heights;
    static int[] canSee;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        heights = new int[N];
        canSee = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }


        force();
        Arrays.sort(canSee);
        System.out.println(canSee[N - 1]);
    }

    static void force(){
        for(int i = 0; i < N - 1; i++){
            canSee[i] += 1;
            canSee[i + 1] += 1;

            double degree = heights[i + 1] - heights[i];

            for(int j = i + 2; j < N; j++){
                double nextDegree = (double)(heights[j] - heights[i])/(j - i);
                if(nextDegree <= degree){
                    continue;
                }
                degree = nextDegree;
                canSee[i]++;
                canSee[j]++;
            }
        }
    }

}
