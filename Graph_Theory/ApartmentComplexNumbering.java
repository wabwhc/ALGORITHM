package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
//2667
public class ApartmentComplexNumbering {
    static final int[] addX = new int[]{1, -1, 0, 0};
    static final int[] addY = new int[]{0, 0, 1, -1};
    static String[][] map;
    static int N;
    static LinkedList<Integer> list = new LinkedList<Integer>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new String[N][N];
        
        //int count1 = 0;
        for(int i = 0; i < N; i++){
            //String[] input = br.readLine().split("");
            //for(int j = 0; j < N; j++){
            //    if(input[j].equals("1")){
            //        count1 += 1;
            //    }
            //}
            map[i] = br.readLine().split("");
        }

        int NumOfComplex = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j <N; j++){
                //건물이 아닌 경우에도 단순한 값 확인이라 if 문 안 쓰는 게 더 좋은 것 같다.
                if(map[i][j].equals("1")){
                    NumOfComplex += 1;
                    //int result = DFS(i, j);
                    //list.add(result);
                    list.add(DFS(i, j));
                    //count1 -= result;
                }
                //if(count1 == 0){
                //    break;
                //}
            }
            //if(count1 == 0){
            //    break;
            //}
        }
        System.out.println(NumOfComplex);
        Collections.sort(list);
        while(!list.isEmpty()){
            System.out.println(list.poll());
        }
    }

    static int DFS(int x, int y){
        Stack<int[]> stack = new Stack<int[]>();
        stack.add(new int[]{x, y});
        map[x][y] = "0";
        int NumOfHouse = 1;
        while(!stack.isEmpty()){
            int[] position = stack.pop();
            for(int i = 0; i < 4; i++){
                int tempX = position[0] + addX[i];
                int tempY = position[1] + addY[i];
                if(tempX >=0 && tempX < N && tempY >=0 && tempY < N){
                    if(map[tempX][tempY].equals("1")){
                        map[tempX][tempY] = "0";
                        stack.push(new int[]{tempX, tempY});
                        NumOfHouse += 1;
                    }
                }
            }
        }

        return NumOfHouse;
    }
}
