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
    public static boolean[][] visited;
    public static int[][] mat; 

    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    public static int n;

    public static void bfs(int y, int x, int h){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(y,x));
        visited[y][x] = true;
        
        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            for(int i = 0;i<4;i++){
                int ny = tmp.y + dy[i];
                int nx = tmp.x + dx[i];

                if(ny>=0 && nx>=0 && ny<n && nx<n){
                    if(visited[ny][nx]==false && mat[ny][nx] >h){
                        queue.offer(new Point(ny,nx));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        mat = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        int max_res = 0;
        for(int h = 0;h<=100;h++){
            visited = new boolean[n][n];
            int cnt = 0;

            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(visited[i][j]==false && mat[i][j]>h){
                        bfs(i,j,h);
                        cnt++;
                    }
                }
            }
            max_res=Math.max(max_res, cnt);
        }
        System.out.println(max_res);
    }
}