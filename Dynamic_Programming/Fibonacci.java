package Dynamic_Programming;

//DP란 무엇인가
//공부 연습
public class Fibonacci {
    static int[] topDown_memo;
    static int[] bottomUp_table;

    public static void main(String[] args) {
        int N = 30;
        topDown_memo = new int[N];
        bottomUp_table = new int[N];


    }

    static int topDown(int N){
        if(N < 2){
            return topDown_memo[N] = N;
        }

        if(topDown_memo[N] > 0){
            return topDown_memo[N];
        }

        topDown_memo[N] = topDown_memo[N - 2] + topDown_memo[N - 1];

        return topDown_memo[N];
    }

    static int bottomUp(int N){
        bottomUp_table[0] = 0;
        bottomUp_table[1] = 1;

        for(int i = 2; i <= N; i++){
            bottomUp_table[i] = bottomUp_table[i - 2] + bottomUp_table[i - 1];
        }

        return bottomUp_table[N];
    }
    





}
