package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//DFSAndBFS1은 map을 배열을 이용했고
//DFSAndBFS2는 map을 linkedlist를 이용했다
public class DFSAndBFS2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int V = Integer.parseInt(st.nextToken());
    
        boolean[] visit = new boolean[N + 1];
        LinkedList<Integer>[] map = new LinkedList[N + 1];

        //LinkedList를 초기화한다.
        for(int i = 0; i < N + 1; i++){
            map[i] = new LinkedList<Integer>();
        }
        for(int i = 0; i < M; i++){
            StringTokenizer input = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(input.nextToken());
            int V2 = Integer.parseInt(input.nextToken());
            map[V1].add(V2);
            map[V2].add(V1);
        }

        sortMap(map);
        //깊은 복사를 한다.
        LinkedList<Integer>[] mapCopy = new LinkedList[map.length];
        for(int i = 0; i < map.length; i++){
            mapCopy[i] = new LinkedList<Integer>(map[i]);
        }
        DFS(visit, mapCopy, V);
        System.out.println();
        //깊은 복사를 한다.
        mapCopy = new LinkedList[map.length];
        for(int i = 0; i < map.length; i++){
            mapCopy[i] = new LinkedList<Integer>(map[i]);
        }
        BFS(visit, mapCopy, V);
    }

    //크기순으로 정렬한다.
    static void sortMap(LinkedList<Integer>[] map){
        for(int i = 1; i < map.length; i++){
            Collections.sort(map[i]);
        }
    }

    //DFSAndBFS1의 방식과 동일하다.
    static boolean[] DFS(boolean[] visit, LinkedList<Integer>[] map, int start){
        boolean[] visitCopy = visit.clone();

        if(!visitCopy[start]){
            System.out.print(start + " ");
            visitCopy[start] = true;

            while(!map[start].isEmpty()){
                visitCopy = DFS(visitCopy, map, map[start].poll());
            }
        }

        return visitCopy;
    }

    //DFSAndBFS1의 방식과 동일하다.
    static void BFS(boolean[] visit, LinkedList<Integer>[] map, int start){
        boolean[] visitCopy = visit.clone();
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(start);
        visitCopy[start] = true;

        while(!queue.isEmpty()){
            int test = queue.poll();
            System.out.print(test + " ");
            while(!map[test].isEmpty()){
                int idx = map[test].poll();
                if(!visitCopy[idx]){
                    queue.add(idx);
                    visitCopy[idx] = true;
                }
            }
        }
    }
}
