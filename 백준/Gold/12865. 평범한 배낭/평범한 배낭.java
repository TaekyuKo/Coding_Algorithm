import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] w = new int[n+1];
        int[] v = new int[n+1];
        for(int i =1;i<=n;i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int[][] dp = new int[k+1][n+1];
        for(int i =1;i<=n;i++){
            for(int j =0;j<=k;j++){
                if(w[i]>j){
                    dp[j][i] = dp[j][i-1];
                }else{
                    dp[j][i] = Math.max(dp[j][i-1], dp[j-w[i]][i-1]+v[i]);
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}