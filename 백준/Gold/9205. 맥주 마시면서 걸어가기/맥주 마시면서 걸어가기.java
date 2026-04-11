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
    public static boolean[] visited;
    public static Queue<Point> queue;
    public static Point[] location;
    
    public static int n;
    
    public static void bfs(){
        while(!queue.isEmpty()){
            Point tmp = queue.poll();

            if(tmp.y == location[n+1].y && tmp.x == location[n+1].x){
                System.out.println("happy");
                return;
            }

            for(int i = 1;i<n+2;i++){
                if(visited[i]==false){
                    int dist = Math.abs(tmp.x-location[i].x) + Math.abs(tmp.y-location[i].y);

                    if(dist<=1000){
                        visited[i] = true;
                        queue.offer(location[i]);
                    }
                }
            }
        }
        System.out.println("sad");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int test =0;test<t;test++){
            n = sc.nextInt();

            queue = new LinkedList<>();
            visited = new boolean[n+2];
            location = new Point[n+2];
            
            for(int i=0;i<n+2;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                location[i] = new Point(y,x);
            }
            
            queue.add(location[0]);
            visited[0] = true;

            bfs();
        }

    }
}