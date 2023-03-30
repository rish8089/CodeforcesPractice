package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximalContinuousRest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(str[i]);
        int leftOnes = consecutiveOnesInBeginning(a, n);
        int rightOnes = consecutiveOnesInEnd(a,n);
        int ans= leftOnes+rightOnes;
        for(int i=0;i<n;i++){
            if(a[i]==1){
                int cnt=1;
                while(i+1<n && a[i+1]==1){
                    cnt++;
                    i++;
                }
                ans=Math.max(ans,cnt);
            }
        }
        System.out.println(ans);
    }
    private static int consecutiveOnesInBeginning(int []a, int n){
        int i=0;
        while(i<n && a[i]==1){
            i++;
        }
        return i;
    }
    private static int consecutiveOnesInEnd(int []a, int n){
        int i=n-1;
        while(i>=0 && a[i]==1){
            i--;
        }
        return n-i-1;
    }
}
