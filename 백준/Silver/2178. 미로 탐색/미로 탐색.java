import java.util.*;

class Point{
    int y;
    int x;
    
    Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}

class Main {
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static String[] str;
    static int[][] dis;


    public static void bfs(int y, int x, int n, int m, boolean[][] visit){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(y,x));
        visit[y][x] = true;

        while(queue.isEmpty() == false){
            Point tmp = queue.poll();
            for(int i =0;i<4;i++){
                int ny = tmp.y + dy[i];
                int nx = tmp.x + dx[i];

                if(ny>=0 && nx>=0 && ny < n && nx < m){
                    if(visit[ny][nx] == false && str[ny].charAt(nx) == '1'){
                        visit[ny][nx] = true;
                        queue.offer(new Point(ny,nx));
                        dis[ny][nx] = dis[tmp.y][tmp.x]+1;     
                    }
                }
            }
        }  
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        str = new String[n]; 
        for(int i = 0;i<n;i++){
            str[i] = sc.next();
        }
        boolean[][] visit = new boolean[n][m];
        dis = new int[n][m];
        dis[0][0] = 1;
        
        bfs(0,0,n,m,visit);

        System.out.println(dis[n-1][m-1]);
    }
}