package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class MinimumScore {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int NumOfScore = Integer.parseInt(st.nextToken());
        int NumOfPeople = Integer.parseUnsignedInt(st.nextToken());
        Integer[] scores = new Integer[NumOfScore];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < NumOfScore; i++){
            scores[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scores, Collections.reverseOrder());
        System.out.println(scores[NumOfPeople - 1]);
        

    }
}
