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
    public static String[] str;
    public static int n;

    public static int bfs(int y, int x){
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(y,x));
        visited[y][x] = true;

        int cnt = 1;

        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            for(int i = 0;i<4;i++){
                int ny = tmp.y + dy[i];
                int nx = tmp.x + dx[i];

                if(ny>=0 && nx>=0 && ny<n && nx<n){
                    if(visited[ny][nx]!=true && str[ny].charAt(nx) == '1'){
                        visited[ny][nx] = true;
                        queue.offer(new Point(ny,nx));
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        str = new String[n];
        for(int i =0;i<n;i++){
            str[i] = sc.next();
        }

        visited = new boolean[n][n];

        List<Integer> town = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(visited[i][j] == false && str[i].charAt(j) == '1'){
                    int res = bfs(i,j);
                    town.add(res);
                }
            }
        }

        Collections.sort(town);
        System.out.println(town.size());
        for(int k : town){
            System.out.println(k);
        }
    }
}