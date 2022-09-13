package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//10026
//메모리초과 출력결과는 맞는 듯
public class RGcolorWeakness {

    static boolean[][] visit;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] inputs = new char[N][N];

        for(int i = 0; i < N; i++){
            inputs[i] = br.readLine().toCharArray();
        }

        int[] start = new int[]{0, 0};
        int count = 0;
        visit = new boolean[N][N];
        while(start[0] != -1){

            start = search(inputs, start, true);
            count += 1;
        }
        System.out.print(count + " ");

        //
        count = 0;
        visit = new boolean[N][N];
        start = new int[]{0, 0};
        while(start[0] != -1){

            start = search(inputs, start, false);
            count += 1;
        }
        System.out.print(count + " ");

    }

    static int[] search(char[][] map, int[] start, boolean type){

        DFS(map, start, type);
        int[] nextPosition = nextPosition();

        return nextPosition;
    }


    static void DFS(char[][] map, int[] start, boolean type){
        int length = map.length;

        char color = map[start[0]][start[1]];

        int[] moveX = new int[]{1, -1, 0, 0};
        int[] moveY = new int[]{0, 0, 1, -1};

        Stack<int[]> stack = new Stack<int[]>();
        stack.add(start);

        while(!stack.isEmpty()){
            int[] currentPosition = stack.pop();
            for(int i = 0; i < 4; i++){
                int tempY = currentPosition[0] + moveY[i];
                int tempX = currentPosition[1] + moveX[i];

                if(check(type, tempX, tempY, length, color, map)){
                    stack.add(new int[]{tempY, tempX});
                    visit[tempY][tempX] = true;
                }
            }
        }
    }

    static boolean check(boolean type, int x, int y, int length, char color, char[][] map){
        if(type){
            if(x >= 0 && x < length && y >= 0 && y < length  &&  color == map[y][x] && !visit[y][x]){
                return true;
            }
        }else{

            if(x >= 0 && x < length && y >= 0 && y < length && !visit[y][x]){
                if(color == 'R' || color == 'G'){
                    if(map[y][x] == 'R' || map[y][x] == 'G'){
                        return true;
                    }
                }else{
                    if(map[y][x] == 'B'){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static int[] nextPosition(){
        int length = visit.length;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                if(visit[i][j] == false){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

}
