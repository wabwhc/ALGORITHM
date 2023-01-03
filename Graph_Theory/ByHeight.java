package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2458
public class ByHeight {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N + 1][N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int inputA = Integer.parseInt(st.nextToken());
            int inputB = Integer.parseInt(st.nextToken());
            map[inputA][inputB] = true;
        }

        // floyd-warshall을 배웠다.
        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                for(int k = 1; k < N + 1; k++){
                    if(map[j][i] && map[i][k]){
                        map[j][k] = true;
                    }
                }
            }
        }


        int result = 0;

        for(int i = 1; i < N + 1; i++){
            int count = 0;
            for(int j = 1; j < N + 1; j++){
                if(map[i][j] || map[j][i]){
                    count += 1;
                }
            }
            if(count == N - 1){
                result += 1;
            }
        }
        
        System.out.println(result);
    }
}
