package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//1991
public class TreeTraversal {

    static class Node {
        int left;
        int right;

        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }

    static ArrayList<Node>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N];

        for(int i = 0; i < N; i++){
            list[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';
            list[index].add(new Node(left, right));
        }

        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);
        System.out.println(sb.toString());
    }

    static void preorder(int start){
        for(Node node: list[start]){
            int left = node.left;
            int right = node.right;

            sb.append((char)(start+'A'));
            if(left != - 19){
                preorder(left);
            }
            if(right != -19){
                preorder(right);
            }
        }
    }


    static void inorder(int start){
        for(Node node: list[start]){
            int left = node.left;
            int right = node.right;

            if(left != - 19){
                inorder(left);
            }
            sb.append((char)(start+'A'));
            if(right != -19){
                inorder(right);
            }
        }
    }

    static void postorder(int start){
        for(Node node: list[start]){
            int left = node.left;
            int right = node.right;

            if(left != - 19){
                postorder(left);
            }
            if(right != -19){
                postorder(right);
            }
           
            sb.append((char)(start+'A'));
        }
    }

}
