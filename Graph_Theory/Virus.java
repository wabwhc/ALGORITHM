package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
//2606
public class Virus {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int computer = Integer.parseInt(st.nextToken()) + 1;
        st = new StringTokenizer(br.readLine());
        int linked = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] map = new LinkedList[computer];
        for(int i = 0; i < computer; i++){
            map[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i < linked; i ++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            map[v1].add(v2);
            map[v2].add(v1);
        }

        int count = DFS(map, 1, computer);
        System.out.println(count);
    }

    //stack을 이용해 DFS를 구현했다.
    static int DFS(LinkedList<Integer>[] map, int start, int NumOfCom){
        Stack<Integer> stack = new Stack<Integer>();
       
        boolean[] visit = new boolean[NumOfCom];
        stack.push(start);
        visit[start] = true;
        int count = -1;

        while(!stack.isEmpty()){
            int idx = stack.pop();
            count += 1;

            while(!map[idx].isEmpty()){
                int tempIdx = map[idx].pop();

                if(!visit[tempIdx]){
                    stack.push(tempIdx);
                    visit[tempIdx] = true;
                }
            }
        }

        return count;
    }
}