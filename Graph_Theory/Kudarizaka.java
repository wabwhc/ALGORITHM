package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1520
public class Kudarizaka {
    static int N;
    static int M;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visit;
    static int[] moveX = new int[]{1, -1, 0, 0};
    static int[] moveY = new int[]{0, 0, 1, -1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N][M];
        map = new int[N][M]; 
        dp = new int[N][M]; 

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                //dp -1로 초기화
                dp[i][j] = -1;
            }
        }


        System.out.println(DfsWithDp(new int[]{0, 0}));

        //int result = DFS(new int[]{0, 0});
        //System.out.println(result);
    }


    //메모리 초과 dp를 이용해 메모리 사용을 줄였다
    /* static int DFS(int[] startPos){
        int count = 0;

        visit[startPos[0]][startPos[1]] = true;
        if(startPos[0] == N - 1 && startPos[1] == M - 1){
            return 1;
        }else{
            int height = map[startPos[0]][startPos[1]];
            for(int i = 0; i < 4; i++){
                int posX = startPos[0] + moveX[i];
                int posY = startPos[1] + moveY[i];
                if(posX >= 0 && posX < N && posY >= 0 && posY < M && !visit[posX][posY]){
                    if(height > map[posX][posY]){
                        count += DFS(new int[]{posX, posY});
                    }
                }
            }
        }
        visit[startPos[0]][startPos[1]] = false;

        return count;
    } */

    static int DfsWithDp(int[] position){

        int x = position[0];
        int y = position[1];
        if(x == N - 1 && y == M - 1){
            return 1;
        }

        if(dp[x][y] == -1){
            dp[x][y] = 0;

            for(int i = 0; i < 4; i++){
                int nx = x + moveX[i];
                int ny = y + moveY[i];
                if(nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1){
                    continue;
                }

                if(map[x][y] > map[nx][ny]){
                    dp[x][y] += DfsWithDp(new int[]{nx, ny});;
                }
            }
        }


        return dp[x][y];
    }
}
