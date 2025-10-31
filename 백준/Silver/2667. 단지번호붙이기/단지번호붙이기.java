import java.util.*;

class Main {
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};
    public static String[] num;
    public static boolean[][] visit;

    public static int sum;

    public static void dfs(int y, int x, int n){
        visit[y][x] = true;
        sum++;
        for(int i =0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && nx >= 0 && ny < n && nx < n){
                if(visit[ny][nx] == false && num[ny].charAt(nx) == '1'){
                    visit[ny][nx] = true;
                    dfs(ny, nx, n);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        visit = new boolean[n][n];
        num = new String[n];
        for(int i =0;i<n;i++){
            num[i] = sc.next();
        }

        ArrayList<Integer> housecnt = new ArrayList<>();

        int total = 0;

        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(visit[i][j]==false && num[i].charAt(j)=='1'){
                    total++;
                    sum = 0;
                    dfs(i,j,n);

                    housecnt.add(sum);
                }else{
                    continue;
                }
            }
        }

        System.out.println(total);

        Collections.sort(housecnt);
        for(int x:housecnt){
            System.out.println(x);
        }
        
    }
}