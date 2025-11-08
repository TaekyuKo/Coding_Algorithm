import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] num = new int[n];
        for(int i = 0;i<n;i++){
            num[i] = sc.nextInt();
        }

        for(int i =0;i<n;i++){
            for(int j =i+1;j<n;j++){
                if(num[i]>num[j]){
                    int tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                }
            }
        }

        int sum = 0;
        int tmp = 0;
        for(int i = 0;i<n;i++){
            tmp+=num[i];
            sum+=tmp;
        }
        System.out.println(sum);
    }
}