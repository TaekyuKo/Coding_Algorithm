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
        int k = sc.nextInt();

        u = new int[n+1];
        for(int i = 1;i<=n;i++){
            u[i] = i;
        }

        int[] elec = new int[k];
        for(int i = 0;i<k;i++){
            elec[i] = sc.nextInt();
        }

        for(int i = 1;i<k;i++){
            root_combine(root_find(elec[0]), elec[i]);
        }

        int[][] cost = new int[m+1][3];
        for(int i = 1;i<=m;i++){
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        Arrays.sort(cost, 1, m+1, (m1, m2) -> m1[2]-m2[2]);

        int e_cnt = 0;
        int e_cost = 0;
        for(int i = 1;i<=m;i++){
            if(e_cnt == n-k){
                break;
            }
            if(root_find(cost[i][0]) == root_find(cost[i][1])){
                continue;
            }

            e_cnt++;
            root_combine(cost[i][0],cost[i][1]);
            e_cost+=cost[i][2];
        }

        System.out.println(e_cost);

        
    }
}