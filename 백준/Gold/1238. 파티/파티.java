import java.util.*;

class Home{
    int end;
    int time;

    public Home(int end, int time){
        this.end = end;
        this.time = time;
    }
}

class Main {
    public static List<Home>[] graph;
    public static int[] dist;
    public static PriorityQueue<Home> queue;

    public static void dijkstra(){
        while(!queue.isEmpty()){
            Home tmp = queue.poll();

            int tmp_node = tmp.end;
            int tmp_time = tmp.time;

            if(tmp_time > dist[tmp_node]){
                continue;
            }

            for(Home next : graph[tmp_node]){
                int new_time = tmp_time + next.time;

                if(new_time < dist[next.end]){
                    dist[next.end] = new_time;
                    queue.offer(new Home(next.end, new_time));
                }
            }
        }
    } 

    public static void initialize(int x, int n){
        for(int i = 1;i<=n;i++){
            dist[i] = 10000000;
        }
        dist[x] = 0;
        queue.offer(new Home(x,0));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int x = sc.nextInt(); 

        graph = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            graph[i] = new ArrayList<Home>();
        }

        for(int i = 0;i<m;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int t = sc.nextInt();

            graph[s].add(new Home(e,t));
        }
        dist = new int[n+1];
        queue = new PriorityQueue<>((e1,e2) -> e1.time - e2.time);
        
        initialize(x,n);
        dijkstra();

        int[] save = new int[n+1];
        for(int i = 1;i<=n;i++){
            save[i] = dist[i];
        }

        int max = 0;
        for(int i =1;i<=n;i++){
            initialize(i,n);
            dijkstra();
            if(save[i]+dist[x]>max){
                max = save[i]+dist[x];
            }
        }
        System.out.println(max);
    }
}