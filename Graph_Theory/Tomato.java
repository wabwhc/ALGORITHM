package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//7576
public class Tomato {
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<int[]> startPositions = new ArrayList<int[]>();
    static int M, N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
    
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int start = Integer.parseInt(st.nextToken());
                if(start == 1){
                    startPositions.add(new int[]{i, j});
                }
                map[i][j] = start;
            }
        }
        int result = BFS();
        System.out.print(result);
    }

    static int BFS(){

        Queue<int[]> queue = new LinkedList<int[]>();
        int[] moveX = new int[]{1, -1, 0, 0};
        int[] moveY = new int[]{0, 0, 1, -1};

        for(int i = 0; i < startPositions.size(); i++){
            int[] startPosition = startPositions.get(i);
            queue.add(startPosition);
            visit[startPosition[0]][startPosition[1]] = true;
        }

        while(!queue.isEmpty()){
            int[] check = queue.poll();
            for(int i = 0; i < 4; i++){
                int visitX = check[0] + moveX[i];
                int visitY = check[1] + moveY[i];
                if(visitX >= 0 && visitX < N && visitY >= 0 && visitY < M && !visit[visitX][visitY] && map[visitX][visitY] == 0){
                    visit[visitX][visitY] = true;
                    queue.add(new int[]{visitX, visitY});
                    //방문하는 위치마다 1씩 더해서 몇번째 방문인지 확인한다
                    map[visitX][visitY] = map[check[0]][check[1]] + 1;
                }

            }
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    return -1;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(max < map[i][j]){
                    max = map[i][j];
                }
            }
        }
        return max - 1;
    }
}
