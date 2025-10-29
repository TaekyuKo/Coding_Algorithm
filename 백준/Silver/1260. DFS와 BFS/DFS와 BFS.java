import java.util.*;

class Main {
    static boolean[] visit;
    static LinkedList<Integer>[] list;

    public static void dfs(int v){
        visit[v] = true;
        System.out.print(v+" ");
        for(int nextV : list[v]){
            if(visit[nextV] == false){
                dfs(nextV);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> que = new LinkedList<>();
        que.offer(v);
        visit[v] = true;

        while(que.isEmpty() == false){
            int tmp = que.poll();
            System.out.print(tmp+" ");

            for(int nextV : list[tmp]){
                if(visit[nextV] == false){
                    que.offer(nextV);
                    visit[nextV] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        list = new LinkedList[n+1];
        visit = new boolean[n+1];
        
        for(int i =1;i<=n;i++){
            list[i] = new LinkedList<Integer>();
        }

        for(int i =1;i<=m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        for(int i =1;i<=n;i++){
            Collections.sort(list[i]);
        }

        dfs(v);
        
        for(int i =0;i<visit.length;i++){
            visit[i] = false;
        }
        System.out.println();
        
        bfs(v);

        
    }
}