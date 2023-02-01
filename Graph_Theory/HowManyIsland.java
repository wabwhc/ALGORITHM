package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class HowManyIsland {
    final static int[] moveX = new int[]{1, -1, 0, 0, 1, 1, -1, -1};
    final static int[] moveY = new int[]{0, 0, 1, -1, 1, -1, 1, -1};

    static int[][] map = null;
    static boolean[][] visit = null;
    static int x = -1;
    static int y = -1;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
    
        while(x != 0 || y != 0){
  

            map = new int[x][y];
            visit = new boolean[x][y];
            
            for(int i = 0; i < x; i++){
                if(y != 0){
                    st = new StringTokenizer(br.readLine());
                }
                for(int j = 0; j < y; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(UseDFS());

            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
        }
    }

    static int UseDFS(){
        int count = 0;

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(!visit[i][j]){
                    if(map[i][j] == 1){
                       DFS(new int[]{i, j});
                       count += 1;
                    }
                }
            }
        }

        return count;
    }

    static void DFS(int[] position){
        Stack<int[]> stack = new Stack<int[]>();
        stack.add(new int[]{position[0], position[1]});
        visit[position[0]][position[1]] = true;

        while(!stack.isEmpty()){
            int[] Current = stack.pop();
            for(int i = 0; i < 8; i++){
                int checkX = Current[0] + moveX[i];
                int checkY = Current[1] + moveY[i];
                
                
                if(checkX >= 0 && checkX < x && checkY >= 0 && checkY < y){
                    if(!visit[checkX][checkY] && map[checkX][checkY] == 1){
                        stack.add(new int[]{checkX, checkY});
                        visit[checkX][checkY] = true;
                    }
                }
            }
        }


    }


}
