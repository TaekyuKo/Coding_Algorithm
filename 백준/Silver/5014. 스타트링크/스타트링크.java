import java.util.*;

class Main {
    public static boolean[] visited;
    public static int[] time;

    public static int f, u, d;

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int x = queue.poll();
            int[] dx = {x+u, x-d};
            for(int i = 0;i<2;i++){
                int nextV = dx[i];
                if(nextV>=1 && nextV<=f){
                    if(visited[nextV]==false && time[nextV]==0){
                        queue.offer(nextV);
                        visited[nextV] = true;
                        time[nextV] = time[x]+1;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        f = sc.nextInt();
        
        int s = sc.nextInt();
        int g = sc.nextInt();
        
        u = sc.nextInt();
        d = sc.nextInt();

        visited = new boolean[1000001];
        time = new int[1000001];
        
        bfs(s);
        if(visited[g] == false){
            System.out.println("use the stairs");
        }else{
            System.out.println(time[g]);
        }
    }
}