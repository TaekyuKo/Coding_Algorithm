import java.util.*;
import java.math.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] w = new int[n+1];
        for(int i =1;i<=n;i++){
            w[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[] res = new int[k+1];
        for(int i = 1;i<=k;i++){
            res[i] = sc.nextInt();
        }

        boolean[][] dp = new boolean[31][40001];
        for(int i = 1;i<=n;i++){
            if(i==1){
                dp[i][w[i]] = true;
            }else{
                dp[i][w[i]] = true;
                for(int j = 0;j<=40000-w[i];j++){
                    if(dp[i-1][j] == true){
                        dp[i][j+w[i]] = true;
                        dp[i][Math.abs(j-w[i])] = true;
                        dp[i][j] = true;
                    }
                }
            }
        }

        for(int i=1;i<k;i++){
            if(dp[n][res[i]] == true){
                System.out.print("Y ");
            }else{
                System.out.print("N ");
            }
        }
        if(dp[n][res[k]] == true){
            System.out.print("Y");
        }else{
            System.out.print("N");
        }
        
        
    }
}