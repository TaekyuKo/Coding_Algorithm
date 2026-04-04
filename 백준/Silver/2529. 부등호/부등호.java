import java.util.*;

class Main {
    public static char[] than;

    public static boolean[] visited = new boolean[10];
    public static String min = "";
    public static String max = "";

    public static void backtrack(int depth, String num){
        if(depth == than.length+1){
            if(min.equals("")){
                min = num;
            }
            max = num;
            return;
        }

        for(int i = 0;i<10;i++){
            if(visited[i] == true){
                continue;
            }

            if(depth == 0){
                visited[i] = true;
                backtrack(depth+1, num+i);
                visited[i] = false;
            }else{
                int prev = num.charAt(depth-1)-'0';
                if((than[depth-1] == '<' && prev < i)||(than[depth-1] == '>' && prev >i)){
                    visited[i] = true;
                    backtrack(depth+1,num+i);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        
        than = new char[k];
        for(int i =0;i<k;i++){
            than[i] = sc.next().charAt(0);
        }

        backtrack(0,"");

        System.out.println(max);
        System.out.println(min);
    }
}