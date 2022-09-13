package Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//2178
//BFS visit를 불값이 아닌 자연수로해서 이전에 있던 값에 1씩 더해서 셈

public class MazeExploration {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean[][] map = new boolean[N + 1][M + 1];
        //boolean[][] visit = new boolean[N + 1][M + 1];

        //이부분 중요
        int[][] visit = new int[N + 1][M + 1];

        for(int i = 1; i < N + 1; i++){
            String[] inputs = br.readLine().split("");
        
            for(int j = 1; j < M + 1; j++){
                if(inputs[j - 1].equals("1")){
                    map[i][j] = true;
                }else{
                    //visit[i][j] = true;
                    //불가능 부분 구분
                    visit[i][j] = -1;
                }
            
            }
        }

        System.out.println(BFS(map, visit));

    }

    static int BFS(boolean[][] map, int[][] visit){
        int lengthY = map.length;
        int lengthX = map[0].length;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        int[] moveX = new int[]{1, -1, 0, 0};
        int[] moveY = new int[]{0, 0, 1, -1};
        queue.add(new int[]{1, 1});
        visit[1][1] = 1;
        //int count = 1;
        
        //int sizeCounting = 0;
        //LinkedList<Integer> list = new LinkedList<>();
        //list.add(1);
        //int size = 0;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            //sizeCounting += 1;
            int currentY = current[0];
            int currentX = current[1];

            for(int i = 0; i < 4; i++){

                int positionX = currentX + moveX[i];
                int positionY = currentY + moveY[i];
                if(positionX >= 1 && positionX <= lengthX - 1 && positionY >= 1 && positionY <= lengthY - 1 && map[positionY][positionX] && visit[positionY][positionX] == 0){
                    queue.add(new int[]{positionY, positionX});
                    visit[positionY][positionX] = visit[currentY][currentX] + 1;
                    //size += 1;
                    if(positionX == lengthX - 1 && positionY == lengthY - 1){
                        //return count += 1;
                        return visit[positionY][positionX];
                    }
                }
            }
    
            //if(list.get(count - 1) == sizeCounting){
            //    list.add(size);
            //    size = 0;
            //    sizeCounting = 0;
            //    count += 1;
            //}
            
        }

        return 0;

    }
}
