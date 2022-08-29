import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class SortInside {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값을 문자열로 받고 배열로 저장한다.
        String[] input = br.readLine().split("");
        int length = input.length;
        Integer[] parseInput = new Integer[length];

        //String배열을 Integer배열로 변환한다.
        for(int i = 0; i < length; i++){
            parseInput[i] = Integer.parseInt(input[i]);
        }
        //정렬후 출력한다.
        Arrays.sort(parseInput, Collections.reverseOrder());
        for(int i = 0; i < length; i++){
            System.out.print(parseInput[i]);
        }
    }
}
