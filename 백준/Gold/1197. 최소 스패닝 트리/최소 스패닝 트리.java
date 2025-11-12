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

        int v = sc.nextInt();
        int e = sc.nextInt();

        u = new int[v+1];
        for(int i = 1;i<=v;i++){
            u[i] = i;
        }

        int[][] abc= new int[e+1][3];
        for(int i = 1;i<=e;i++){
            abc[i][0] = sc.nextInt();
            abc[i][1] = sc.nextInt();
            abc[i][2] = sc.nextInt();
        }
        Arrays.sort(abc, 1, e+1, (t1,t2) -> t1[2] - t2[2]);

        int e_cnt = 0;
        long e_val = 0;
        for(int i =1;i<=e;i++){
            if(e_cnt == v-1){
                break;
            }

            if(root_find(abc[i][0]) == root_find(abc[i][1])){
                continue;
            }
            e_cnt++;
            root_combine(abc[i][0], abc[i][1]);
            e_val+=abc[i][2];
        }
        System.out.println(e_val);  
    }
}