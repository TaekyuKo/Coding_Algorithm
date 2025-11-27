import java.util.*;

class Route{
    int node;
    int length;

    public Route(int node, int length){
        this.node = node;
        this.length = length;
    }
}

class Main {
    public static long[] dist;
    public static long INF = 10000000000L;
    public static List<Route>[] graph;
    public static int n, m, r;

    public static void dijkstra(int start){
        for(int i = 1;i<=n;i++){
            dist[i] = INF;
        }
        dist[start] = 0;
        
        PriorityQueue<Route> queue = new PriorityQueue<>((e1,e2) -> e1.length - e2.length);
        queue.offer(new Route(start,0));

        while(!queue.isEmpty()){
            Route tmp = queue.poll();

            int tmp_node = tmp.node;
            int tmp_length = tmp.length;

            if(tmp_length > dist[tmp_node]){
                continue;
            }

            for(Route next : graph[tmp_node]){
                int next_dist = tmp_length + next.length;

                if(next_dist < dist[next.node]){
                    dist[next.node] = next_dist;
                    queue.offer(new Route(next.node,next_dist));
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        int[] item = new int[n+1];
        for(int i = 1;i<=n;i++){
            item[i] = sc.nextInt();
        }

        graph = new ArrayList[n+1];
        for(int i =1;i<=n;i++){
            graph[i] = new ArrayList<Route>();
        }

        for(int i = 0;i<r;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = sc.nextInt();

            graph[a].add(new Route(b,l));
            graph[b].add(new Route(a,l));
        }

        dist = new long[n+1];

        int max = 0;
        for(int i = 1;i<=n;i++){
            dijkstra(i);

            int tmp_max = 0;
            for(int j = 1;j<=n;j++){
                if(dist[j] <= m){
                    tmp_max+=item[j];
                }
            }
            max = Math.max(max, tmp_max);
        }

        System.out.println(max);
    }
}