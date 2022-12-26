package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//2573
public class Iceberg {
    static int[][] map;
    static boolean[][] visit;
    static final int[] addX = new int[]{1, -1, 0, 0};
    static final int[] addY = new int[]{0, 0, 1, -1};
    static int N;
    static int M;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
            }
        }

        int countTurn = -1;
        while(true){
            countTurn += 1;
            visit = new boolean[N][M];
            int count = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M ; j++){
                    if(map[i][j] > 0 && !visit[i][j]){
                        DFS(i, j);
                        count += 1;
                    }
                }
            }

            if(count == 0){
                System.out.println(0);
                break;
            }

            if(count >= 2){
                System.out.println(countTurn);
                break;
            }
            turn();
        }

    }
    static void turn(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int count = 0;
                for(int k = 0; k < 4; k++){
                    int tempX = i + addX[k];
                    int tempY = j + addY[k];
                    if(tempX >=0 && tempX < N && tempY >=0 && tempY < M){
                        if(!visit[tempX][tempY]){
                            count += 1;
                        }
                    }
                }
                if(map[i][j] > 0){
                    map[i][j] -= count;
                }
            }
        }
    }

    static void DFS(int x, int y){
        Stack<int[]> stack = new Stack<int[]>();
        stack.add(new int[]{x, y});
        visit[x][y] = true;

        while(!stack.isEmpty()){
            int[] position = stack.pop();
            for(int i = 0; i < 4; i++){
                int tempX = position[0] + addX[i];
                int tempY = position[1] + addY[i];
                if(tempX >=0 && tempX < N && tempY >=0 && tempY < M){
                    if(map[tempX][tempY] > 0 && !visit[tempX][tempY]){
                        visit[tempX][tempY] = true;
                        stack.add(new int[]{tempX, tempY});
                    }
                }
            }
        }
    }

}
