import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] p = new long[91];
        p[4] = 1;
        for(int i =5;i<=n;i++){
            p[i] = p[i-1]+p[i-2];
        }


        long[] dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;
        for(int i =3;i<=n;i++){
            dp[i] = dp[i-1] * 2 - p[i];
        }

        System.out.print(dp[n]);
    }
}