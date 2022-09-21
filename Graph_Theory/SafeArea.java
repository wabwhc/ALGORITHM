package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//2468
public class SafeArea {
    static int[][] map;
    static int N;
    static boolean[][] visit;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        int maxheight = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > maxheight){
                    maxheight = map[i][j];
                }
            }
        }

        int max = -1;
        for(int i = 0; i < maxheight; i++){
            int result = work(i);
            //결과를 저장하고 그 결과 값이 저장된 max보다 크면 max에 저장한다
            if(result > max){
                max = result;
            }
            //visit 초기화
            visit = new boolean[N][N];
        }

        System.out.println(max);
    }

    static int work(int height){
        int count = 0;
        int[] position = new int[]{0, 0};
        while(true){
            //높이조건에 맞고 방문하지 않은 좌표값을 찾는다.
            position = FindLowThan(height);
            if(position[0] == -1){
                break;
            }
            //조건에 맞는 좌표로 DFS를 실행한다
            DFS(position, height);
            count += 1;
        }

        return count;
    }

    static int[] FindLowThan(int height){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] > height && !visit[i][j]){
                    return new int[]{i, j};
                }
            }
        }

        //조건에 맞는 것이 없으면 [-1, -1]을 리턴한다.ㅏ
        return new int[]{-1, -1};
    }

    //DFS실행
    static void DFS(int[] position, int height){
        Stack<int[]> stack = new Stack<int[]>();
        stack.add(position);
        //boolean[][] copyVisit = new boolean[N][N];
        //for(int i = 0; i < N; i++){
        //    System.arraycopy(visit[i], 0, copyVisit[i], 0, N);
        //}
        //copyVisit[position[0]][position[1]] = true;
        visit[position[0]][position[1]] = true;
        
        int[] moveX = new int[]{1, -1, 0, 0};
        int[] moveY = new int[]{0, 0, 1, -1};

        while(!stack.isEmpty()){
            int[] currentPosition = stack.pop();
            for(int i = 0; i < 4; i++){
                int x = currentPosition[0] + moveX[i];
                int y = currentPosition[1] + moveY[i];

                if(x >= 0 && x < N && y >= 0 && y < N && map[x][y] > height && !visit[x][y]){
                    stack.add(new int[]{x, y});
                    visit[x][y] = true;
                }
            }
        }

        //return copyVisit;
    }
}
