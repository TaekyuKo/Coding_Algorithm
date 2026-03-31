import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] num = new int[n];
        for(int i = 0;i<n;i++){
            num[i] = sc.nextInt();
        }

        int[] sum = new int[n];
        for(int i = 1;i<n;i++){
            sum[i] = sum[i-1]+num[i];
        }

        for(int k = 0;k<m;k++){
            int i = sc.nextInt();
            int j = sc.nextInt();

            System.out.println(sum[j-1]-sum[i-1]+num[i-1]);
        }
    }
}