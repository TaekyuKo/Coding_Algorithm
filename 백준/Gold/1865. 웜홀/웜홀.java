import java.util.*;

class Road{
    int start;
    int end;
    int time;

    public Road(int start, int end, int time){
        this.start = start;
        this.end = end;
        this.time = time;
    }
}

class Main {
    public static Road[] road;

    public static boolean bellman(int n, int m, int w){
        long[] dist = new long[n+1];
        for(int j =1;j<=n;j++){
            dist[j] = 0;
        }

        for(int j = 0;j<n;j++){
            for(int k = 1;k<=2*m+w;k++){
                if(dist[road[k].end] > dist[road[k].start] + road[k].time){
                    dist[road[k].end] = dist[road[k].start] + road[k].time;

                    if(j == n-1){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for(int i = 0;i<tc;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int w = sc.nextInt();

            road = new Road[2*m+w+1];
            for(int j = 1;j<=m+w;j++){
                int s = sc.nextInt();
                int e = sc.nextInt();
                int t = sc.nextInt();

                if(j<=m){
                    road[j] = new Road(s,e,t);
                    road[j+m] = new Road(e,s,t);
                }else{
                    road[j+m] = new Road(s,e,-t);
                }
            }

            boolean res = bellman(n,m,w);

            if(res){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}