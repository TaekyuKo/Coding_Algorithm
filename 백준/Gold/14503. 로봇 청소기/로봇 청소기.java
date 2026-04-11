import java.util.*;

class Main {
    public static int[] dy = {-1,0,1,0};
    public static int[] dx = {0,1,0,-1};

    public static int[][] clean;
    public static int n,m;
    public static int cnt = 0;

    public static void dfs(int y, int x, int d){
        if(clean[y][x] == 0){
            clean[y][x] = 2;
            cnt++;
        }

        for(int i = 0;i<4;i++){
            d = (d+3)%4;

            int ny = y+dy[d];
            int nx = x+dx[d];

            if(ny>=0 && nx>=0 && ny<n && nx<m && clean[ny][nx]==0){
                dfs(ny,nx,d);
                return;
            }
        }

        int back_d = (d+2)%4;
        int by = y+dy[back_d];
        int bx = x+dx[back_d];

        if(by>=0 && bx>=0 && by<n && bx<m && clean[by][bx]!=1){
            dfs(by,bx,d);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();

        int d = sc.nextInt();

        clean = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                clean[i][j] = sc.nextInt();
            }
        }
        dfs(r,c,d);
        System.out.println(cnt);

        
    }
}