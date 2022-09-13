package Data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//10773
public class Zero {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < K; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                stack.pop();
            }else{
                stack.add(input);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.println(sum);

    }
}
