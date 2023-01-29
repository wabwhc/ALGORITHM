package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

//7785
public class Easywork {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<String, String>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String inputName = st.nextToken();

            if(map.containsKey(inputName)){
                map.remove(inputName);
            }else{
                map.put(inputName, st.nextToken());
            }
        }

        ArrayList<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());

        for(String item : list){
            System.out.print(item + " ");
        }
    }
}
