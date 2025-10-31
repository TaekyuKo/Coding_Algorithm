import java.util.*;

class Main {
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};
    public static boolean[][] visit;
    public static int[][] num;


    public static void dfs(int y, int x, int m, int n){
        visit[y][x] = true;
        for(int i =0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && nx >= 0 && ny < n && nx < m){
                if(visit[ny][nx] == false && num[ny][nx] == 1){
                    visit[ny][nx] = true;
                    dfs(ny, nx, m,n);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i =0;i<t;i++){
            int m = sc.nextInt();
            int n = sc.nextInt();

            num = new int[n][m];
            visit = new boolean[n][m];
            
            int k = sc.nextInt();
            
            for(int j = 0;j<k;j++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                num[y][x] = 1;
            }

            int cnt = 0;
            for(int a = 0;a<m;a++){
                for(int b = 0;b<n;b++){
                    if(visit[b][a] == false && num[b][a] == 1){
                        cnt++;
                        dfs(b,a,m,n);
                    }
                }
            }
            System.out.println(cnt);

            for(int a = 0;a<m;a++){
                for(int b = 0;b<n;b++){
                    visit[b][a] = false;
                    num[b][a] = 0;
                }
            }

        }


    }
}