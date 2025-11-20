import java.util.*;
class Line{
    int neighbor;
    int weight;

    public Line(int neighbor, int weight){
        this.neighbor = neighbor;
        this.weight = weight;
    }
}

class Main {
    public static List<Line>[] graph;
    public static PriorityQueue<Line> queue;
    public static int[] dist;

    public static void dijkstra(){
        while(!queue.isEmpty()){
            Line tmp = queue.poll();

            int tmp_node = tmp.neighbor;
            int tmp_weight = tmp.weight;

            if(tmp_weight > dist[tmp_node]){
                continue;
            }

            for(Line next : graph[tmp_node]){
                int next_weight = tmp_weight + next.weight;

                if(next_weight < dist[next.neighbor]){
                    dist[next.neighbor] = next_weight;
                    queue.offer(new Line(next.neighbor, next_weight));
                }
            }
        }
    }

    public static void initial(int x,int n){
        for(int i = 1;i<=n;i++){
            dist[i] = 100000000;
        }
        dist[x] = 0;
        queue.offer(new Line(x,0));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        graph = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            graph[i] = new ArrayList<Line>();
        }

        for(int i = 0;i<e;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a].add(new Line(b,c));
            graph[b].add(new Line(a,c));
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        dist = new int[n+1];
        
        queue = new PriorityQueue<>((e1,e2) -> e1.weight - e2.weight);

        long res_v1_v2 = 0;
        initial(1,n);
        dijkstra();
        res_v1_v2+=dist[v1];

        initial(v1,n);
        dijkstra();
        res_v1_v2+=dist[v2];

        initial(v2,n);
        dijkstra();
        res_v1_v2+=dist[n];

        long res_v2_v1 = 0;
        initial(1,n);
        dijkstra();
        res_v2_v1+=dist[v2];

        initial(v2,n);
        dijkstra();
        res_v2_v1+=dist[v1];

        initial(v1,n);
        dijkstra();
        res_v2_v1+=dist[n];

        long ans = Math.min(res_v1_v2, res_v2_v1);

        if (ans >= 100000000) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
        
    }
}