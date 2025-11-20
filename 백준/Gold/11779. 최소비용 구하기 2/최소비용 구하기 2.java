import java.util.*;

class Bus{
    int end;
    int weight;

    public Bus(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Bus>[] graph = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            graph[i] = new ArrayList<Bus>();
        }

        for(int i =0;i<m;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();

            graph[s].add(new Bus(e,w)); 
        }
        
        int start = sc.nextInt();
        int destination = sc.nextInt();

        int[] dist = new int[n+1];
        for(int i = 1;i<=n;i++){
            dist[i] = 100000000;
        }
        dist[start] = 0;

        int[] route = new int[n+1];
        for(int i = 1;i<=n;i++){
            route[i] = 0;
        }
        
        PriorityQueue<Bus> queue = new PriorityQueue<>((e1,e2) -> e1.weight-e2.weight);
        queue.offer(new Bus(start,0));
        while(!queue.isEmpty()){
            Bus tmp = queue.poll();

            int tmp_node = tmp.end;
            int tmp_weight = tmp.weight;

            if(tmp_weight > dist[tmp_node]){
                continue;
            }

            for(Bus next : graph[tmp_node]){
                int next_weight = tmp_weight + next.weight;

                if(next_weight < dist[next.end]){
                    dist[next.end] = next_weight;
                    queue.offer(new Bus(next.end, next_weight));
                    route[next.end] = tmp.end;
                }
            }
        }

        System.out.println(dist[destination]);

        int[] back = new int[n+1];
        int back_idx = 0;

        int res_cnt = 0;
        int tmp_rt = destination;
        while(tmp_rt != 0){
            back[back_idx++] = tmp_rt;
            tmp_rt = route[tmp_rt];
            res_cnt++;
        }

        System.out.println(res_cnt);
        for(int i = res_cnt-1;i>=0;i--){
            System.out.print(back[i]+" ");
        }

        
    }
}