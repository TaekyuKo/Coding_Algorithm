import java.util.*;

class Main {
    
    public static int lower_bound(int[] box, int left, int right, int k){
        while(left<right){
            int mid = (left+right)/2;
            if(box[mid]<k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        int[] box = new int[n+1];
        for(int i =1;i<=n;i++){
            box[i] = sc.nextInt();
        }

        int[] lis = new int[n+1];
        int[] dp = new int[n+1];

        int lis_idx = 0;
        for(int i =1;i<=n;i++){
            if(lis[lis_idx]<box[i]){
                lis_idx++;
                lis[lis_idx] = box[i];
                dp[i] = dp[i-1]+1;
            }else{
                lis[lower_bound(lis, 1, lis_idx, box[i])] = box[i];
                dp[i] = dp[i-1];
            }
        }

        System.out.println(dp[n]);
        
    }
}