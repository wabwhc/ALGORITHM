package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//16437
public class RescueSheep {
    static final int sheep = 1;
    static final int wolf = 0;

    static int[][] states;
    static LinkedList<Integer>[] tree;
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        states = new int[N + 1][2];
        tree = new LinkedList[N + 1];

        for(int i = 0; i < N + 1; i++){
            tree[i] = new LinkedList<Integer>();
        }

        states[1][0] = 1;
        states[1][1] = 0;
        for(int i = 2; i < N + 1; i ++){
            st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if(t.equals("S")){
                states[i][0] = sheep;
            }else{
                states[i][0] = wolf;
            }
            states[i][1] = a;
            
            //문제에 1로 가는 길은 한가지라고 명시되어 있어 양방향으로 할 필요 없음
            tree[p].add(i);
        }


        long result = DFS(1);
        System.out.println(result);
        
    }

    static long DFS(int idx){
        long result = 0;
        for(int child: tree[idx]){
            result += DFS(child);
        }

        if(states[idx][0] == sheep){
            return result + states[idx][1];

        }else if(states[idx][0] == wolf){
            if(result <= states[idx][1]){
                states[idx][1] -= result;
                return 0;

            }else{
                result -= states[idx][1];
                states[idx][1] = 0;
                return result;
            }

        }

        return 0;
    }
}
