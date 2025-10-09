import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();


        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i = 1;i<=str1.length();i++){
            for(int j = 1;j<=str2.length();j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    if(dp[i-1][j] > dp[i][j-1]){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }

        char[] res = new char[1001];
        int res_idx = 0;
        int idx_a = str1.length();
        int idx_b = str2.length();
        
        while(!(idx_a==0||idx_b==0)){
            if(dp[idx_a][idx_b] == dp[idx_a-1][idx_b]){
                idx_a--;
                continue;
            }else if(dp[idx_a][idx_b] == dp[idx_a][idx_b-1]){
                idx_b--;;
                continue;
            }else{
                res[res_idx] = str1.charAt(idx_a-1);
                res_idx++;
                idx_a--;
                idx_b--;
            }
        }
            

        System.out.println(dp[str1.length()][str2.length()]);
        for(int i = res_idx-1;i>=0;i--){
            System.out.print(res[i]);
        }
        
    }
}