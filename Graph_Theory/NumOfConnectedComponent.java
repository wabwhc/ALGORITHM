package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
//11724
//DFS를 이용했다
public class NumOfConnectedComponent {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] map = new LinkedList[N];
        boolean[] visit = new boolean[N];
        int count = 0;
        
        for(int i = 0; i < N; i++){
            map[i] = new LinkedList<Integer>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a - 1].add(b - 1);
            map[b - 1].add(a - 1);
        }
        
        for(int i = 0; i < N; i++){
            if(!visit[i]){
                count += 1;
                visit = DFS(visit, map, i);
            }
        }

        System.out.println(count);
    }

    static boolean[] DFS(boolean[] visit, LinkedList<Integer>[] map, int start){
        boolean[] visitCopy = visit.clone();
        Stack<Integer> stack = new Stack<Integer>();
        
        stack.add(start);
        visitCopy[start] = true;
        while(!stack.isEmpty()){
            int index = stack.pop();
            while(!map[index].isEmpty()){
                int tmp = map[index].pop();
                if(!visitCopy[tmp]){
                    visitCopy[tmp] = true;
                    stack.add(tmp);
                }
            }
        }
        
        return visitCopy;
    }
}
