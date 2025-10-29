import java.util.*;

class Main {
    static boolean[] visit;
    static LinkedList<Integer>[] list;
    static Deque<Integer> stack;

    public static void dfs(int v){
        visit[v] = true;
        stack.push(v);
        for(int nextV :list[v]){
            if(visit[nextV] == false){
                dfs(nextV);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stack = new ArrayDeque<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        list = new LinkedList[n+1];
        visit = new boolean[n+1];
        for(int i =1;i<=n;i++){
            list[i] = new LinkedList<Integer>();
        }
        
        for(int i =1;i<=m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            list[u].add(v);
            list[v].add(u);
        }

        int cnt = 0;
        for(int i =1;i<=n;i++){
            if(visit[i] == false){
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);


    }
}