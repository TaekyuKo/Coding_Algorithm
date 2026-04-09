import java.util.*;

class Point{
    int y;
    int x;
    
    public Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}

class Main {
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    public static boolean[][] visited;
    public static int[][] ice;

    public static int n, m;

    public static void bfs(int y, int x){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(y,x));
        visited[y][x] = true;

        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            for(int i = 0;i<4;i++){
                int ny = tmp.y + dy[i];
                int nx = tmp.x + dx[i];

                if(ny>=0 && nx>=0 && ny<n && nx<m){
                    if(visited[ny][nx]==false && ice[ny][nx]>0){
                        visited[ny][nx] = true;
                        queue.offer(new Point(ny,nx));
                    }
                }
            }
        }
    }

    public static void minus(){
        int[][] melt = new int[n][m];
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(ice[i][j]>0){
                    int cnt = 0;
                    for(int k = 0;k<4;k++){
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if(ny>=0 && nx>=0 && ny<n &&nx<m){
                            if(ice[ny][nx]<=0){
                                cnt++;
                            }
                        }
                    }
                    melt[i][j] = cnt;
                }
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(ice[i][j]>0){
                    ice[i][j] = ice[i][j] - melt[i][j];
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ice = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                ice[i][j] = sc.nextInt();
            }
        }

        int res = -1;
        for(int y = 0;y<=100000000;y++){
            visited = new boolean[n][m];
            int cnt = 0;
            for(int i = 1;i<n-1;i++){
                for(int j = 1;j<m-1;j++){
                    if(ice[i][j]>0 &&visited[i][j]==false){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            if(cnt>=2){
                res = y;
                break;
            }
            if(cnt==0){
                res = 0;
                break;
            }
            minus(); // 1년마다 빙하 녹는 로직
        }

        System.out.println(res);
    }
}