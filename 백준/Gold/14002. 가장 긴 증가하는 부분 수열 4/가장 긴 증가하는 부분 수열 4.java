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
        int[] pre_index = new int[n+1];

        int[] index = new int[n+1];

        int lis_idx = 0;
        for(int i =1;i<=n;i++){
            if(lis[lis_idx]<a[i]){
                lis_idx++;
                lis[lis_idx] = a[i];
                index[lis_idx] = i;
                pre_index[i] = index[lis_idx-1];
            }else{
                int tmp = lower_bound(lis, 1, lis_idx, a[i]);
                lis[tmp] = a[i];
                index[tmp] = i;
                pre_index[i] = index[tmp-1];
            }
        }

        int res_idx = 1;
        int[] res = new int[n+1];

        int idx = index[lis_idx]; 
        int cnt = 0;
        while(idx !=0){
            res[res_idx] = a[idx];
            idx = pre_index[idx];
            res_idx++;
            cnt++;
        }

        System.out.println(cnt);
        for(int i =res_idx-1;i>=1;i--){
            System.out.print(res[i]+" ");
        }

        
    }
}