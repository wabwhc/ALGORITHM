package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//1260
//DFSAndBFS1은 map을 배열을 이용했고
//DFSAndBFS2는 map을 linkedlist를 이용했다
public class DFSAndBFS1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int V = Integer.parseInt(st.nextToken());
        //입력값과 배열의 index를 비교하기 편하도록 크기를 N+1로 저장한다. 
        boolean[] visit = new boolean[N + 1];
        boolean[][] map = new boolean[N + 1][N + 1];
        

        for(int i = 0; i < M; i++){
            StringTokenizer input = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(input.nextToken());
            int V2 = Integer.parseInt(input.nextToken());
            //연결된 정점들을 저장한다.
            map[V1][V2] = true;
            map[V2][V1] = true;
        }

        DFS(visit, map, V);
        System.out.println();
        BFS(visit, map, V);
    }

    //DFS방식이다.
    //재귀함수를 이용했다.
    //방문한것은 visitCopy를 true저장하고 map을 이용해 연결된 정점들을 탐색한다.
    static boolean[] DFS(boolean[] visit, boolean[][] map, int start){
        boolean[] visitCopy = visit.clone();

        if(!visitCopy[start]){
            System.out.print(start + " ");
            visitCopy[start] = true;

            for(int i = 0; i < map[start].length; i++){
                if(map[start][i]){
                    visitCopy = DFS(visitCopy, map, i);
                }
            }
        }

        return visitCopy;
    }

    //BFS방식이다.
    //Queue를 이요했다.
    //map을 이용해 시작 정점과 연결된 모든 정점을 Queue에 더하는 것을 반복한다.
    static void BFS(boolean[] visit, boolean[][] map, int start){
        boolean[] visitCopy = visit.clone();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);

        visitCopy[start] = true;
        while(!queue.isEmpty()){
            int idx = queue.poll();
            System.out.print(idx + " ");

            for(int i = 0; i < map[start].length; i++){

                if(map[idx][i] && !visitCopy[i]){
                    visitCopy[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
