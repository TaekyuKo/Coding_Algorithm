import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] idx = new int[n];
        int[] t = new int[n];
        int[] s = new int[n];
        double[] div = new double[n];
        
        for(int i = 0;i<n;i++){
            idx[i] = i+1;
            t[i] = sc.nextInt();
            s[i] = sc.nextInt();

            div[i] =  t[i] / (double)s[i];
        }

        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(div[i]>div[j] || (Double.compare(div[i], div[j]) == 0 && idx[i] > idx[j])){
                    double div_tmp = div[i];
                    int idx_tmp = idx[i];
                    
                    div[i] = div[j];
                    idx[i] = idx[j];
                    
                    div[j] = div_tmp;
                    idx[j] = idx_tmp;
                }
            }
        }

        for(int i = 0;i<n;i++){
            System.out.print(idx[i]+" ");
        }
    }
}