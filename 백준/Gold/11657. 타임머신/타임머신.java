import java.util.*;

class Bus{
    int start;
    int end;
    int time;
    
    public Bus(int start, int end, int time){
        this.start = start;
        this.end = end;
        this.time = time;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Bus[] city = new Bus[m];
        for(int i = 0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            city[i] = new Bus(a,b,c);
        }
     
        long[] dist = new long[n+1];
        long INF = 10000000000L;
        for(int i =1;i<=n;i++){
            dist[i] = INF;
        }
        dist[1] = 0;
        
        long[] save = new long[n+1];
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dist[city[j].start] != INF){
                    if(dist[city[j].end] > dist[city[j].start] + city[j].time){
                        dist[city[j].end] = dist[city[j].start] + city[j].time;
                    }
                }
            }
        }

        boolean cycle = false;
        for(int j=0;j<m; j++){
            if(dist[city[j].start] != INF){
                if(dist[city[j].end] > dist[city[j].start] + city[j].time){
                    cycle = true;
                    break;
                }
            } 
        }

        if(cycle == true){
            System.out.println(-1);
        }else{
            for(int i =2;i<=n;i++){
                if(dist[i] == INF){
                    System.out.println(-1);
                }else{
                    System.out.println(dist[i]);
                }
            }
        }
    }
}