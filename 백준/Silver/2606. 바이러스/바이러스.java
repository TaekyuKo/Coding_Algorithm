import java.util.*;

class Main {
    public static LinkedList<Integer>[] graph;
    public static boolean[] visit;

    public static void dfs(int v){
        visit[v] = true;
        for(int nextV : graph[v]){
            if(visit[nextV] != true){
                dfs(nextV);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();

        visit = new boolean[n+1];
        

        graph = new LinkedList[n+1];
        for(int i = 1;i<=n;i++){
            graph[i] = new LinkedList<Integer>();
        }

        for(int i = 0;i<p;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);

        int cnt = 0;
        for(int i =1;i<=n;i++){
            if(visit[i] == true){
                cnt++;
            }
        }
        System.out.println(cnt-1);  
    }
}