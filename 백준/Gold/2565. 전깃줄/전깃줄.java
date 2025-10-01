import java.util.*;

class Main {
    public static int lower_bound(int[] b, int left, int right, int k){
        while(left<right){
            int mid = (left+right)/2;
            if(b[mid]<k){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for(int i =1;i<=n;i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        for(int i =1;i<=n;i++){
            for(int j =i+1;j<=n;j++){
                if(a[i]>a[j]){
                    int tmp_a = a[i];
                    int tmp_b = b[i];
                    a[i] = a[j];
                    b[i] = b[j];
                    a[j] = tmp_a;
                    b[j] = tmp_b;
                }
            }
        }

        int[] lis = new int[n+1];
        int[] dp = new int[n+1];

        int lis_idx = 0;
        for(int i =1;i<=n;i++){
            if(lis[lis_idx]<b[i]){
                lis_idx++;
                lis[lis_idx] = b[i];
                dp[i] = dp[i-1]+1;
            }else{
                lis[lower_bound(lis, 1, lis_idx,b[i])] = b[i];
                dp[i] = dp[i-1];
            }
        }

        System.out.println(n-dp[n]);

    }
}