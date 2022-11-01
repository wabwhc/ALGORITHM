package Data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//17298
public class BigNumAtRight{
    static int N;
    static int[] inputs;
    static Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }
    

        //메인 로직
        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && inputs[stack.peek()] < inputs[i]){
                inputs[stack.pop()] = inputs[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            inputs[stack.pop()] = -1;
        }

        //StringBuilder 안쓰면 시간초과나옴
        StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(inputs[i]).append(' ');
		}
		
		System.out.println(sb);
        
    }
}