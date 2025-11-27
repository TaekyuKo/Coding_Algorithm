import java.util.*;

class Farm{
    int end;
    int feed;
    
    public Farm(int end, int feed){
        this.end = end;
        this.feed = feed;
    }
}

class Main {
    public static int n,m;
    public static List<Farm>[] graph;
    public static long[] dist;
    public static final long INF = 500000000L;

    public static void dijkstra(int start){
        dist = new long[n+1];
        for(int i = 1;i<=n;i++){
            dist[i] = INF;
        }
        dist[start] = 0;

        PriorityQueue<Farm> queue = new PriorityQueue<>((e1,e2) -> e1.feed - e2.feed);
        queue.offer(new Farm(start,0));

        while(!queue.isEmpty()){
            Farm tmp = queue.poll();
            int tmp_end = tmp.end;
            int tmp_feed = tmp.feed;

            if(tmp_feed > dist[tmp_end]){
                continue;
            }

            for(Farm next : graph[tmp_end]){
                int next_feed = tmp_feed + next.feed;

                if(next_feed < dist[next.end]){
                    dist[next.end] = next_feed;
                    queue.offer(new Farm(next.end, next_feed));
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            graph[i] = new ArrayList<Farm>();
        }
        
        for(int i = 1;i<=m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a].add(new Farm(b,c));
            graph[b].add(new Farm(a,c));
        }

        dijkstra(1);
        System.out.println(dist[n]);
    }
}