package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

//1707
//왜틀렸는지 모르겠네
public class BipartiteGraph {
    static final char red = 'R';
    static final char blue = 'B';
    

    public static void main(String[] args)throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int K = Integer.parseInt(br.readLine());
      
      for(int i = 0; i < K; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        LinkedList<Integer>[] map = new LinkedList[V + 1];
        
        for(int j = 0; j < V + 1; j++){
            map[j] = new LinkedList<Integer>();
        }

        for(int j = 0; j < E; j++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x].add(y);
            map[y].add(x);
        }

        String isPossible = isBipGraph(map) ? "YES" : "NO";
        System.out.println(isPossible);

      }
      

    }

    static boolean isBipGraph(LinkedList<Integer>[] map){
        int length = map.length;
        int test = 0;
        char[] visit = new char[length];
        visit[1] = red;
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(1);
        
        while(!stack.isEmpty()){
            test += 1;
            char color = blue;
            if(test % 2 == 0){
                color = red;
            }
            int idx = stack.pop();

            for(int i = 0; i < map[idx].size(); i++){
                int stp = map[idx].pop();

                if(color != visit[stp] && visit[stp] != '\u0000'){
                    return false;
                }
                visit[stp] = color;
                stack.add(stp);
            }

        }

        return true;
    }
}
