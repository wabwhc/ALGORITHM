import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//16956
public class WolfAndSheep {
    public static void main(String[] ags) throws IOException{
        int r, c;
        char[][] map;
        Queue<int[]> queue = new LinkedList<int[]>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력값 저장
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        //map에 늑대와 양 표시 저장
        map = new char[r][c];
        
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                char InputChar = s.charAt(j);
                map[i][j] = InputChar;
                if(InputChar == 'W'){
                    queue.add(new int[]{i, j});
                }
            }
        }

        char[][] result;
        if(!queue.isEmpty()){
            result = fence(queue, map, r, c);
        }else{
            //늑대가없으면 map을 저장하면 됨
            result = map;
        }

        //result의 길이가 0이면 성립안됨
        if(result.length != 0){
            System.out.println("1");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }else{
            System.out.println("0");
        }
    
    }
    //울타리를 포함한 map을 만들어 반환함
    //늑대 주변을 울타리로 감쌈
    static char[][] fence(Queue<int[]> argQueue, char[][] map, int r, int c){
        char[][] result = map.clone();

        int[] addX = {-1, 1, 0, 0};
        int[] addY = {0, 0, 1, -1};
        while(!argQueue.isEmpty()){
            int[] position = argQueue.poll();
            int x = position[0];
            int y = position[1];
            
            for(int i = 0; i < 4; i++){
                int roundX = x + addX[i];
                int roundY = y + addY[i];

                if(roundX >= 0 && roundX < r && roundY >= 0 && roundY < c){
                    if(map[roundX][roundY] == '.'){
                        result[roundX][roundY] = 'D';
                    }else if(map[roundX][roundY] == 'S'){
                        //늑대바로 옆에 양이 있으면 성립못함
                        return new char[0][0];
                    }
                }
            }
       }

        return result;
    }
}