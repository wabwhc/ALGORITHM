package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//19542
public class FlyerDelivery {
    static LinkedList<Integer>[] tree;
    static int[] visit;
    static int power;
    static int start;
    static int N;
    static int count = 0;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        // 기본 정보 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        power = Integer.parseInt(st.nextToken());

        //배열 초기화
        tree = new LinkedList[N + 1];
        // visit 각 depth 저장
        visit = new int[N + 1];

        for(int i = 1; i < N + 1; i++){
            tree[i] = new LinkedList<Integer>();
        }

        // 연결관계입력
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        DFS(start, -1);
        System.out.println(count * 2);
    }



    static int DFS(int current, int parent){
        // 이거쓰면 시간초과
        //int size = tree[current].size();
        //for(int i = 0; i < size; i++){
        //    int temp = tree[current].get(i);
        //    if(temp != parent){
        //        visit[current] = Math.max(visit[current], DFS(temp, current) + 1);
        //    }
        //}

        // for each문이 빠르긴 빠름
        for(int temp: tree[current]){
            if(temp != parent){
                visit[current] = Math.max(visit[current], DFS(temp, current) + 1);
           }
        }

        if(start != current && visit[current] + 1 > power){
            count += 1;
        }

        return visit[current];
    }
}
