package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//7869
public class TwoCircle {
    static double[][] circles = new double[2][3];
    static double distance;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                circles[i][j] = Double.parseDouble(st.nextToken());
            }
        }

        distance = Math.sqrt(Math.pow(circles[0][0] - circles[1][0], 2) + Math.pow(circles[0][1] - circles[1][1], 2));

        if(circles[0][2] + circles[1][2] <= distance){
            System.out.println(String.format("%.3f", (double)0));
        }else if(Math.abs(circles[0][2] - circles[1][2]) >= distance){
            System.out.println(String.format("%.3f", Math.PI * Math.pow(Math.min(circles[0][2], circles[1][2]), 2)));
        }else{
            double theta1 = Math.acos((circles[0][2] * circles[0][2] + distance * distance - circles[1][2] * circles[1][2]) / (2 * circles[0][2] * distance));
			double theta2 = Math.acos((circles[1][2] * circles[1][2] + distance * distance - circles[0][2] * circles[0][2]) / (2 * circles[1][2] * distance));

			double S1 = (circles[0][2] * circles[0][2] * theta1) - (circles[0][2] * circles[0][2] * Math.sin(2 * theta1) / 2);
			double S2 = (circles[1][2] * circles[1][2] * theta2) - (circles[1][2] * circles[1][2] * Math.sin(2 * theta2) / 2);
			System.out.println(String.format("%.3f", S1 + S2));;
        }

    }
}
