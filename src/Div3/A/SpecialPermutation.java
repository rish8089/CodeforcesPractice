package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] res = new int[n];
            for (int i = 0; i < n; i += 2) {
                if (i + 1 < n) {
                    res[i] = i + 2;
                    res[i + 1] = i + 1;
                } else {
                    res[i] = i + 1;
                }
            }
            if(n%2!=0){
                swap(res,n-1,1);
            }
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<n;i++)
                ans.append(res[i]).append(" ");
            System.out.println(ans);
            t--;
        }
    }
    private static void swap(int []a, int i, int j){
        int t = a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
