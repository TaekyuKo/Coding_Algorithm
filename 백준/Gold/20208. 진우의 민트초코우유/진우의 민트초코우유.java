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
    public static List<Point> milks;
    public static Point house;
    public static int n,m,h;

    public static boolean[] visited;
    public static int maxcnt = 0;
    
    public static void dfs(int y, int x, int hp, int cnt){
        int dist = Math.abs(y - house.y) + Math.abs(x - house.x);
        if(hp>=dist){
            maxcnt = Math.max(maxcnt, cnt);
        }

        for(int i = 0;i<milks.size();i++){
            if(visited[i] == false){
                Point nextM = milks.get(i);

                int dist_next = Math.abs(y-nextM.y) + Math.abs(x-nextM.x);
                if(hp >= dist_next){
                    visited[i] = true;
                    dfs(nextM.y, nextM.x, hp-dist_next+h, cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();

        milks = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                int value = sc.nextInt();
                if(value == 2){
                    milks.add(new Point(i,j));
                }else if(value == 1){
                    house = new Point(i,j);
                }
            }
        }

        visited= new boolean[10];
        dfs(house.y, house.x, m, 0);
        System.out.println(maxcnt);
    }
}