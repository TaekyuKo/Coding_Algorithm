import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] t = new int[n][2];
        for(int i =0;i<n;i++){
            t[i][0] = sc.nextInt();
            t[i][1] = sc.nextInt();
        }

        Arrays.sort(t, (m1,m2) ->{
            if(m1[1] == m2[1]){
                return m1[0]-m2[0];
            }else{
                return m1[1]-m2[1];
            }
        });

        int cnt = 1;
        int tmp_end = t[0][1];
        for(int i =1;i<n;i++){
            if(tmp_end<=t[i][0]){
                cnt++;
                tmp_end = t[i][1];
            }
        }

        System.out.println(cnt);

        
    }
}