package Data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1717
//union-find 알고리즘
public class ExpressionOfSet {
    static int[] parent;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //배열의 index는 요소
        //배열의 값은 해당요소의 parent값
        //집합을 연결형식으로 해석함
        parent = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            parent[i] = i;
        }

        for(int i  = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int method = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(method == 1){
                System.out.println(sameParent(x, y));
            }else if(method == 0){
                union(x, y);
            }

        }

    }

    //parent찾음
    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    //결합
    static void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);

        if(parentX > parentY){
            parent[parentX] = y;

        }else if(parentX < parentY){
            parent[parentY] = x;
        }
    }

    //동일한 parent이지 확인
    static String sameParent(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX == parentY){
            return "YES";
        }
        return "NO";
    }
}
