import java.util.*;

class Main {
    public static int doub;
    public static int[] time;

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        
        while(!queue.isEmpty()){
            int x = queue.poll();
            int[] nextX = {x-1,x+1,x*2};
            
            for(int i = 0;i<3;i++){
                int nx = nextX[i];
                if(nx>=0 && nx<=100000){
                    if(time[x]+1<time[nx]){
                        queue.offer(nx);
                        time[nx] = time[x]+1;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        time = new int[100001];
        for(int i = 0;i<=100000;i++){
            time[i] = 100000;
        }

        time[n] = 0;
        bfs(n);

        System.out.println(time[k]);
    }
}