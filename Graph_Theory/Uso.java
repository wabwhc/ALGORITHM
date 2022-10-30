package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

//1043
public class Uso {
    static int N;
    static int M;
    static int k;
    static LinkedList<Integer>[] map;
    static boolean[] visit;
    static int[][] memberOfpart;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new LinkedList[N + 1];
        visit = new boolean[N + 1];
        memberOfpart = new int[M][];

        for(int i = 0; i < N + 1; i++){
            map[i] = new LinkedList<Integer>();
        }

        //알고있는 사람 배열
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        int[] already = new int[k];
        for(int i = 0; i < k; i++){
            already[i] = Integer.parseInt(st.nextToken());
        }

        //파티 배열
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int NumOfMember = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            memberOfpart[i] = new int[NumOfMember];
            memberOfpart[i][0] = first;

            for(int j = 0; j < NumOfMember - 1; j++){
                int member = Integer.parseInt(st.nextToken());
                map[first].add(member);
                map[member].add(first);
                memberOfpart[i][j + 1] = member;
            }
        }

        //DFS를 이용해 해결함
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < k; i++){
            int t = already[i];
            stack.add(t);
            visit[t] = true;
        }

        while(!stack.isEmpty()){
            int member = stack.pop();

            for(int i: map[member]){
                if(!visit[i]){
                    stack.add(i);
                    visit[i] = true;
                }
            }
        }

        int count = 0;
        boolean isPossible = true;
        for(int i = 0; i < M; i++){
            isPossible = true;
            for(int j: memberOfpart[i]){
                if(visit[j]){
                    isPossible = false;
                    continue;
                }
            }

            if(isPossible){
                count += 1;
            }
        }

        System.out.println(count);
    }
}
