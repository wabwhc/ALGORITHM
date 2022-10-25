package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//1931
public class MeetingRoomAssignment {
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N][2];
       

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(schedule, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1]; 
            }
        });

        int count = 0;
        int pre_time = 0;
        for(int i = 0; i < N; i++){
            if(pre_time <= schedule[i][0]){
                pre_time = schedule[i][1];
                count += 1;
            }
        }
        
        System.out.println(count);
    }
}
