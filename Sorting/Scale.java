import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2437
public class Scale {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬함
        Arrays.sort(array);

        int sum = 0;
        for(int i = 0; i < N; i++){
            if(sum + 1 < array[i]){
                break;
            }
            //작은거부터 더함
            sum += array[i];
        }

        System.out.println(sum + 1);
    }
}
