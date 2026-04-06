import java.util.*;

class Main {
    public static LinkedList<Integer>[] graph;
    public static boolean[] visited;

    public static void dfs(int v){
        visited[v] = true;
        System.out.print(v+" ");
        for(int nextV : graph[v]){
            if(visited[nextV] != true){
                dfs(nextV);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.print(tmp+" ");

            for(int nextV : graph[tmp]){
                if(visited[nextV] != true){
                    queue.add(nextV);
                    visited[nextV] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        graph = new LinkedList[n+1];
        visited = new boolean[n+1];

        for(int i =1;i<=n;i++){
            graph[i] = new LinkedList<Integer>();
        }
        
        for(int i = 0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i = 1;i<=n;i++){
            Collections.sort(graph[i]);
        }
        
        dfs(v);

        for(int i = 1;i<=n;i++){
            visited[i] = false;
        }
        System.out.println();

        bfs(v);

    }
}