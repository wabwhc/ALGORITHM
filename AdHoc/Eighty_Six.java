import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//25595
public class Eighty_Six {
    static int N;
    static int[][] map;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 좌표 찾아서 체스판 처럼 판단한다
        int x = 0;
        int y = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int k = Integer.parseInt(st.nextToken());
                map[i][j] = k;
                if(k == 2){
                    x = i % 2; y = j % 2;
                    if(x == 1){
                        x = 0;
                        if(y == 0){
                            y = 1;
                        }else{
                            y = 0;
                        }
                    }
                }
            }
        }


        boolean result = true;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i % 2 == 0){
                    if(j % 2 == y){
                        if(map[i][j] == 1){
                            result = false;
                            break;
                        }
                    }
                }else{
                    if(j % 2 != y){
                        if(map[i][j] == 1){
                            result = false;
                            break;
                        }
                    }
                }
            }
            
            if(!result){
                break;
            }
        }

        if(result){
            System.out.println("Lena");
        }else{
            System.out.println("Kiriya");
        }


        
        
    }
}
