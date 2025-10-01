import java.util.*;

class Main {
    public static int lower_bound(int[] a , int left, int right, int k){
        while(left<right){
            int mid = (left+right)/2;
            if(a[mid]<k){
                left = mid+1;
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
        for(int i = 1;i<=n;i++){
            a[i] = sc.nextInt();
        }

        int[] lis = new int[n+1];
        int[] dp = new int[n+1];

        int lis_idx = 0;
        for(int i =1;i<=n;i++){
            if(lis[lis_idx]<a[i]){
                lis_idx++;
                lis[lis_idx] = a[i];
                dp[i] = dp[i-1]+1;
            }else{
                lis[lower_bound(lis, 1, lis_idx, a[i])] = a[i];
                dp[i] = dp[i-1];
            }
        }

        System.out.println(dp[n]);
    }
}