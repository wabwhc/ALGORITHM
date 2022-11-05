package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
//7662
//시간초가 다시 문제 풀어야함
public class DualPriorityQueue {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < k; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String method = st.nextToken();
                int data = Integer.parseInt(st.nextToken());
                list = operation(list, method, data);
            }
            System.out.println(BigSamll(list));
        }
    }
    
    static ArrayList<Integer> operation(ArrayList<Integer> preList, String method, int data){
        ArrayList<Integer> copyList = new ArrayList<Integer>();

        for(int i = 0; i < preList.size(); i++){
            copyList.add(preList.get(i));
        }


        int preSize = copyList.size();
        if(method.equals("I")){
            copyList.add(data);
            Collections.sort(copyList);

        }else if(preSize == 0){

        }else if(data == -1){
            copyList.remove(copyList.size() - 1);
        }else{
            copyList.remove(0);
        }
        
        return copyList;

    }

    static String BigSamll(ArrayList<Integer> list){
        int MinValueInList;
        int MaxValueInList;
        int size = list.size();
        if(size == 0){
            return "EMPTY";
        }else if(size == 1){
            int value = list.get(0);
            MinValueInList = value;
            MaxValueInList = value;
        }else{
            MaxValueInList = list.get(0);
            MinValueInList = list.get(size - 1);
        }

        return MaxValueInList + " " + MinValueInList;
    }
}
