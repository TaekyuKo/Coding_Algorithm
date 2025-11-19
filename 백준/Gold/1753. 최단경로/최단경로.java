import java.util.*;

class Edge{
    int neighbor;
    int weight;

    public Edge(int neighbor, int weight){
        this.neighbor = neighbor;
        this.weight = weight;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int e = sc.nextInt();

        int k = sc.nextInt();

        List<Edge>[] graph = new ArrayList[V+1];
        for(int i = 1;i<=V;i++){
            graph[i] = new ArrayList<Edge>();
        }
        for(int i =1;i<=e;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Edge(v,w));
        }

        int[] dist = new int[V+1];
        for(int i = 1;i<=V;i++){
            dist[i] = 1000000000;
        }
        dist[k] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>( (e1,e2) -> e1.weight - e2.weight);
        queue.offer(new Edge(k,0));
        while(!queue.isEmpty()){
            Edge tmp = queue.poll();

            int tmp_node = tmp.neighbor;
            int tmp_weight = tmp.weight;

            if(tmp_weight > dist[tmp_node]){
                continue;
            }

            for(Edge neigh : graph[tmp_node]){
                int new_dist = tmp_weight + neigh.weight;

                if(new_dist < dist[neigh.neighbor]){
                    dist[neigh.neighbor] = new_dist;
                    queue.offer(new Edge(neigh.neighbor,new_dist));
                }
            }
        }

        for(int i = 1;i<=V;i++){
            if(dist[i] == 1000000000){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
   
    }
}