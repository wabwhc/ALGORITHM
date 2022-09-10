package Data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
//1966
public class Printer_Queue {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException, NumberFormatException  {
        
        int Case = Integer.parseInt(br.readLine());
    
        while(Case != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int C = Integer.parseInt(st.nextToken());
            final int M = Integer.parseInt(st.nextToken());


            LinkedList<int[]> list;
            list = makeList(C);

            int count = 0;
            while(!list.isEmpty()){
                
                int[] frontData = search(list);

                if(frontData.length != 0){
                    count += 1;
                    if(frontData[0] == M){
                        System.out.println(count);
                        break;
                    }
                }

            }

            Case -= 1;
        }
    }
    //입력값으로 원래위치와 중요도를 저장한다. 완성된 배열을 반환함
    static LinkedList<int[]> makeList(int howMany)throws IOException, NumberFormatException {
        LinkedList<int[]> list = new LinkedList<int[]>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < howMany; i++){
            int importance =  Integer.parseInt(st.nextToken());
            list.add(new int[]{i, importance});
        }
        return list;
    }
    //배열의 첫번째 값을 저장하고 나머지와 중요도를 비교한다.
    //중요도가 낮다면 뒤로 보낸다. 중요다가 가장 높다면 중요도와 원래위치가 저장된 배열을 반환한다.
    //위를 반복한다.
    static int[] search(LinkedList<int[]> list){
        int size = list.size();
        int[] frontData = list.poll();
        for(int i = 0;i < size - 1; i++){
            int[] listData = list.get(i);
            if(listData[1] > frontData[1]){
                list.add(frontData);
                for(int  j = 0; j < i - 1; j++){
                    list.add(list.poll());
                }
                return new int[]{};
            }
        }
        return frontData;
    }
}
