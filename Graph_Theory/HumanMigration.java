package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//16234
public class HumanMigration {
    static int N;
    static int L;
    static int R;
    static int[][] Population;
    static boolean[][] visit;
    final static int[] moveX = new int[]{1, -1, 0, 0};
    final static int[] moveY = new int[]{0, 0, 1, -1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
    
        Population = new int[N][N];
        visit = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                Population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(check());

    }

    static int check(){
        boolean isMoved = false;

        int count = 0;

        while(true){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visit[i][j]){
                        BFS(i, j);
                    }else{
                        isMoved = true;
                    }
                }
            }

            if(isMoved){
                count += 1;
                isMoved = false;
            }else{
                return count;
            }

            visit = new boolean[N][N];
        }

    }

    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{x, y});
        LinkedList<int[]> OpenBorder = new LinkedList<int[]>();
        OpenBorder.add(new int[]{x, y});
        visit[x][y] = true;
        int SumOfPopulation = Population[x][y];
        int NumOfCountry = 1;

        while(!queue.isEmpty()){
            int[] position = queue.poll();

            for(int i = 0; i < 4; i++){
                int checkX = position[0] + moveX[i];
                int checkY = position[1] + moveY[i];
                if(checkX >= 0 && checkX < N && checkY >= 0 && checkY < N && !visit[checkX][checkY]){
                    int gap = Math.abs(Population[position[0]][position[1]] - Population[checkX][checkY]);

                    if(gap >= L && gap <= R){
                        visit[checkX][checkY] = true;
                        OpenBorder.add(new int[]{checkX, checkY});
                        queue.add(new int[]{checkX, checkY});
                        SumOfPopulation += Population[checkX][checkY];
                        NumOfCountry += 1;
                    }

                }
            }
        }

        int Avg = (int)(SumOfPopulation / NumOfCountry);
        if(OpenBorder.size() > 1){
            while(!OpenBorder.isEmpty()){
                int[] position = OpenBorder.poll();
                Population[position[0]][position[1]] = Avg;
            }
        }
    }
}
