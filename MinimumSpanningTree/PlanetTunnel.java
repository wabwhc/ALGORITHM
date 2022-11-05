package MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//2887
public class PlanetTunnel {

    //행성 클래스를 생성
    static class Planet{
        int num;
        int x, y, z;
        public Planet(int num, int x, int y, int z){
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int N;
    static int[] parent;
    static int ans;
    static Planet[] planets;
    static PriorityQueue<int[]> pq;

    //부모가 같으면 연결
    //부모 지정
    static void union(int x, int y){
        parent[findSet(y)] = parent[findSet(x)];
    }

    //부모를 찾음
    static int findSet(int x){
        if(parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }

    //각 좌표별 차
    static void createEdge(){
        Arrays.sort(planets, new Comparator<Planet>() {
            public int compare(Planet o1, Planet o2){
                return Integer.compare(o1.x, o2.x);
            }
        });

        for(int i = 1; i < N; i++){
            int distance = Math.abs(planets[i].x - planets[i - 1].x);
            pq.add(new int[]{planets[i].num, planets[i - 1].num, distance});
        }

        Arrays.sort(planets, new Comparator<Planet>() {
            public int compare(Planet o1, Planet o2){
                return Integer.compare(o1.y, o2.y);
            }
        });

        for(int i = 1; i < N; i++){
            int distance = Math.abs(planets[i].y - planets[i - 1].y);
            pq.add(new int[]{planets[i].num, planets[i - 1].num, distance});
        }

        Arrays.sort(planets, new Comparator<Planet>() {
            public int compare(Planet o1, Planet o2){
                return Integer.compare(o1.z, o2.z);
            }
        });

        for(int i = 1; i < N; i++){
            int distance = Math.abs(planets[i].z - planets[i - 1].z);
            pq.add(new int[]{planets[i].num, planets[i - 1].num, distance});
        }
        
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        //거리차별로 정렬해서 큐에서 뺌
        pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[2], o2[2]);
            }
        });

        N = Integer.parseInt(br.readLine());
        planets = new Planet[N];
        parent = new int[N];
        //입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i, x, y, z);
            parent[i] = i;
        }
        createEdge();
        int cnt = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(findSet(cur[0]) != findSet(cur[1])){
                ans += cur[2];
                if(++cnt == N - 1) break;
                union(cur[0], cur[1]);
            }
        }
        System.out.println(ans);
    }
}
