package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//7568
public class Bulk {

    static class person{
        int height;
        int weight;
        public person(int height, int weight){
            this.height = height;
            this.weight = weight;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        person[] inputs = new person[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            inputs[i] = new person(height, weight);
        }
        rank(inputs);
    }

    static void rank(person[] people){
        int length = people.length;

        for(int i = 0; i < length; i++){
            int count = 1;
            for(int j = 0; j < length; j++){
                if(people[i].weight < people[j].weight && people[i].height < people[j].height){
                    count += 1;
                }
            }
            System.out.print(count + " ");
        }


    }
}
