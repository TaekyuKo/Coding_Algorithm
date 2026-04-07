import java.util.*;

class Point{
    int h;
    int y;
    int x;
    public Point(int h, int y, int x){
        this.h = h;
        this.y = y;
        this.x = x;
    }
}

class Main {
    public static int[] dh = {0,0,0,0,1,-1};
    public static int[] dy = {0,1,0,-1,0,0};
    public static int[] dx = {1,0,-1,0,0,0};
    
    public static boolean[][][] visited;
    public static int[][][] depth;
    public static int[][][] tomato;

    public static int m,n,h;

    public static Queue<Point> queue = new LinkedList<>();

    public static void bfs(){
        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            for(int i = 0;i<6;i++){
                int nh = tmp.h + dh[i];
                int ny = tmp.y + dy[i];
                int nx = tmp.x + dx[i];

                if(nh>=0 && ny>=0 && nx>=0 && nh<h && ny<n && nx<m){
                    if(visited[nh][ny][nx]==false && tomato[nh][ny][nx]==0){
                        visited[nh][ny][nx] = true;
                        queue.offer(new Point(nh,ny,nx));
                        depth[nh][ny][nx] = depth[tmp.h][tmp.y][tmp.x]+1;
                    }
                }
            }
            
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        tomato = new int[h][n][m];        
        depth = new int[h][n][m];
        visited = new boolean[h][n][m];
        
        for(int a = 0;a<h;a++){
            for(int b = 0;b<n;b++){
                for(int c = 0;c<m;c++){
                    tomato[a][b][c] = sc.nextInt();
                    if(tomato[a][b][c] == 1){
                        queue.offer(new Point(a,b,c));
                        visited[a][b][c] = true;
                    }
                }
            }
        }

        bfs();

        int flag = 0;
        int max = 0;
        for(int a = 0;a<h;a++){
            for(int b = 0;b<n;b++){
                for(int c = 0;c<m;c++){
                    if(tomato[a][b][c]==0 && visited[a][b][c] == false){
                        flag = -1;
                    }
                    max = Math.max(max,depth[a][b][c]);
                }
            }
        }

        if(flag == -1){
            System.out.println(flag);
        }else{
            System.out.println(max);
        }

    }
}