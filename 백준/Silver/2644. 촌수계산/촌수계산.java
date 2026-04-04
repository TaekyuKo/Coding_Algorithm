import java.util.*;

class Main {
    public static boolean[] visited;
    public static LinkedList<Integer>[] list;
    public static int result = -1;

    public static void dfs(int v,int w,int depth){
        if(v == w){
            result = depth;
            return;
        }
        visited[v] = true;
        for(int nextV : list[v]){
            if(visited[nextV] == false){
                dfs(nextV,w,depth+1);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int p1 = sc.nextInt();
        int p2 = sc.nextInt();

        int m = sc.nextInt();

        visited = new boolean[n+1];
        list = new LinkedList[n+1];
        for(int i = 1;i<=n;i++){
            list[i] = new LinkedList<Integer>();
        }
 
        for(int i = 0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            list[y].add(x);
        }

        dfs(p1,p2,0);

        System.out.println(result);

    }
}