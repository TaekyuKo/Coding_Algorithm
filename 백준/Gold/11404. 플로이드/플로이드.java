import java.util.*;

class Main {
    public static final long INF = 100000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] res = new long[n+1][n+1];

        for(int i =1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                res[i][j] = INF;
                if(i==j){
                    res[i][j] = 0;
                }
            }
        }

        for(int i = 0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(res[a][b]>c){
                res[a][b] = c;
            }
        }

        for(int k = 1;k<=n;k++){
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n;j++){
                    if(res[i][j] > res[i][k]+res[k][j]){
                        res[i][j] = res[i][k]+res[k][j];
                    }
                }
            }
        }

        for(int i =1;i<=n;i++){
            for(int j =1;j<=n;j++){
                if(res[i][j] == INF){
                    System.out.print(0+" ");
                }else{
                    System.out.print(res[i][j]+" ");
                }
            }
            System.out.println();
        }

        
    }
}