import java.util.*;

class City{
    int dest;
    int weight;
    
    public City(int dest, int weight){
        this.dest = dest;
        this.weight = weight;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<City>[] graph = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            graph[i] = new ArrayList<City>();
        }

        for(int i = 1;i<=m;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();

            graph[s].add(new City(e,w));
        }

        int start = sc.nextInt();
        int destination = sc.nextInt();

        int[] dist = new int[n+1];
        for(int i = 1;i<=n;i++){
            dist[i] = 100000000;
        }
        dist[start] = 0;

        PriorityQueue<City> queue = new PriorityQueue<>( (e1, e2) -> e1.weight - e2.weight);
        queue.offer(new City(start,0));
        while(!queue.isEmpty()){
            City tmp = queue.poll();

            int tmp_dest = tmp.dest;
            int tmp_weight = tmp.weight;

            if(tmp_weight > dist[tmp_dest]){
                continue;
            }

            for(City next : graph[tmp_dest]){
                int new_dist = tmp_weight + next.weight;

                if(new_dist < dist[next.dest]){
                    dist[next.dest] = new_dist;
                    queue.offer(new City(next.dest, new_dist));
                }
            }
        }

        System.out.println(dist[destination]);
    }
}