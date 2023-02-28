package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cheese {
    static int x, y;
    static boolean[][] visited; 
    static int[][] map; 
    static int numOfCheese;

    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {1, -1, 0, 0};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new int[y][x];
        visited = new boolean[y][x];

        for(int i = 0; i < y; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < x; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int ans = 0;
        for(ans = 0; isCheese(); ans++){
            //초기화
            for (boolean[] arr : visited) {
				Arrays.fill(arr, false);
			}

            visited[0][0] = true;
            numOfCheese = 0;
            DFS(0, 0);
        }

        System.out.println(ans);
        System.out.println(numOfCheese);
    }

    public static boolean isCheese(){
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(map[i][j] == 2){
                    map[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(map[i][j] == 1){
                    return true;
                }
            }
        }

        return false;
    }

    public static void DFS(int positionX, int positionY){
        for(int i = 0 ; i < 4; i++){
            int dx = positionX + moveX[i];
            int dy = positionY + moveY[i];

            if (dx < 0 || dy < 0 || dx >= x || dy >= y) {
                //continue 넣으면 else문 안넣어도 됨
				continue;
			}

            if (!visited[dy][dx]) {
				visited[dy][dx] = true;
				if (map[dy][dx] == 1) {
					map[dy][dx] = 2;
					numOfCheese++; // 다음에 지워질 치즈의 개수
				} else {
					DFS(dx, dy);
				}
			}

        }
    }
}
