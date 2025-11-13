import java.util.*;

class Main {
    public static int[] u;

    public static int root_find(int x){
        if(u[x] != x){
            u[x] = root_find(u[x]);
        }
        return u[x];
    }

    public static void root_combine(int a, int b){
        a = root_find(a);
        b = root_find(b);
        if(a!=b){
            if(a<b){
                u[b] = a;
            }else{
                u[a] = b;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        u = new int[n+1];
        for(int i =1;i<=n;i++){
            u[i] = i;
        }

        double[][] cost = new double[n*n + m+1][3]; 

        int[] x = new int[n+1];
        int[] y = new int[n+1];
        for(int i = 1;i<=n;i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int cost_idx = 1;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                cost[cost_idx][0] = i;
                cost[cost_idx][1] = j;
                cost[cost_idx][2] = Math.sqrt(Math.pow((double)x[i]-x[j], 2) + Math.pow((double)y[i]-y[j], 2));
                cost_idx++;
            }
        }

        for(int i =0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            cost[cost_idx][0] = a;
            cost[cost_idx][1] = b;
            cost[cost_idx][2] = 0;
            cost_idx++;
        }
        Arrays.sort(cost, 1, n*n+m+1, (m1,m2) -> Double.compare(m1[2] ,m2[2]));

        int e_cnt = 0;
        double e_min = 0;
        for(int i = 1;i<=n*n+m+1;i++){
            if(e_cnt == n-1){
                break;
            }
            if(root_find((int) cost[i][0]) == root_find((int) cost[i][1])){
                continue;
            }
            e_cnt++;
            root_combine((int) cost[i][0], (int) cost[i][1]);
            e_min+=cost[i][2];
        }

        System.out.printf("%.2f\n", e_min);
    }
}