import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] p = new int[n+1];
        for(int i =1;i<=n;i++){
            p[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            int min = 10001;
            for(int j =0;j<i;j++){
                if(min > dp[j] + p[i-j]){
                    min = dp[j] + p[i-j];
                }
            }
            dp[i] = min;
        }

        System.out.println(dp[n]);
    }
}