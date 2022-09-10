package BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//11723
//비트마스크 연습
public class Set {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int bitset = 0;

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            int data;

            switch(method){
                case "add":
                    data = Integer.parseInt(st.nextToken());
                    bitset |= (1 << (data - 1));
                    break;
                case "remove":
                    data = Integer.parseInt(st.nextToken());
                    bitset = bitset & ~(1 << (data - 1));
                    break;
                case "check":
                    data = Integer.parseInt(st.nextToken());
                    int result = (bitset & (1 << (data - 1))) != 0 ? 1 : 0;
                    sb.append(result + "\n");
                    break;
                case "toggle":
                    data = Integer.parseInt(st.nextToken());
                    bitset ^= (1 << (data - 1));
                    break;
                case "all":
                    bitset |= (~0);
                    break;
                case "empty":
                    bitset &= 0;
                    break;
            }

        }
        System.out.println(sb.toString());

    }
}
