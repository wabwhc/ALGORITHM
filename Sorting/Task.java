import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//13904
public class Task {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        int[][] inputs = new int[N][2];
        boolean[] visit = new boolean[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            inputs[i][0] = Integer.parseInt(st.nextToken());
            inputs[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0]; 
                }
            }
            
        });

        // for(int i = 0; i < N; i++){
        //     System.out.println(inputs[i][0] + "    " + inputs[i][1]);
        // }

        int sum = 0;
        int currentDay = 0;
        for(int i = N - 1; i >= 0; i--){
            int day = inputs[i][0];
            int score = inputs[i][1];
            
        }

    }
}
