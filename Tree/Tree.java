package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

//1068
public class Tree {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        LinkedList<Integer>[] tree = new LinkedList[N];

        for(int i = 0; i < N; i++){
            tree[i] =  new LinkedList<Integer>();
        }

        int root = 0;
        for(int i = 0; i < N; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent != -1){
                tree[parent].add(i);
            }else{
                root = i;
            }
        }

        int deleted = Integer.parseInt(br.readLine());

        int count = 0;

        Stack<Integer> stack = new Stack<Integer>();
        if(root == deleted){
            System.out.println(0);
        }else{
            stack.add(root);
            while(!stack.empty()){
                int idx = stack.pop();
                int children = tree[idx].size();

                if(children == 0){
                    count += 1;
                }else{
                    Boolean isEmpty = true;
                    for(int i = 0; i < children; i++){
                        int childrenIdx = tree[idx].get(i);
    
                        if(childrenIdx != deleted){
                            stack.add(childrenIdx);
                            isEmpty = false;
                        }
                    }
                    if(isEmpty){
                        count += 1;
                    }
                }
            }
    
            System.out.println(count);
        }
    }
}
