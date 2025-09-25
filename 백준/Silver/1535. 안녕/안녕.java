import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] l = new int[n+1];
        for(int i =1;i<=n;i++){
            l[i] = sc.nextInt();
        }

        int[] j = new int[n+1];
        for(int i = 1;i<=n;i++){
            j[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][1000];
        for(int a =1;a<=n;a++){
            for(int b =0;b<1000;b++){
                if(a==1 && l[a]>b){
                    dp[a][b+1] = dp[a][b];
                }else if(l[a]<=b){
                    dp[a][b] = Math.max(dp[a-1][b], dp[a-1][b-l[a]]+j[a]);
                }else{
                    dp[a][b] = dp[a-1][b];
                }
            }
        }

        System.out.println(dp[n][99]);
    }
}