package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Bestseller {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseUnsignedInt(br.readLine());
        Map<String, Integer> BooksCount = new TreeMap<String, Integer>();

        for(int i = 0; i < N; i++){
            String BookName = br.readLine();
            if(BooksCount.containsKey(BookName)){
                BooksCount.put(BookName, BooksCount.get(BookName) + 1);
            }else{
                BooksCount.put(BookName, 1);
            }
        }
        
        int max = 0;
        String maxName = "";
        //TreeMap은 key기준으로 정렬이 되니 추가적인 처리 필요없음
        for(String BookName : BooksCount.keySet()){
            int BookCount = BooksCount.get(BookName);
            if(max < BookCount){
                maxName = BookName;
                max = BookCount;
            }
        }

        System.out.println(maxName);
    }
}
