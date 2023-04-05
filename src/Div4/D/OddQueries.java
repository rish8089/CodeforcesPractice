//package Div4.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nq=br.readLine().split(" ");
            int n=Integer.parseInt(nq[0]);
            int q=Integer.parseInt(nq[1]);
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            long []prefixSum=new long[n];
            for(int i=0;i<n;i++){
                if(i==0)
                    prefixSum[i]=a[i];
                else
                    prefixSum[i]=prefixSum[i-1]+a[i];
            }
            while (q > 0) {
                str = br.readLine().split(" ");
                int l = Integer.parseInt(str[0]);
                int r = Integer.parseInt(str[1]);
                int k = Integer.parseInt(str[2]);
                System.out.println((prefixSum[n - 1] - (prefixSum[r - 1] - (l > 1 ? prefixSum[l - 2] : 0)) + (long) k * (r - l + 1)) % 2 != 0 ? "YES" : "NO");
                q--;
            }
            t--;
        }
    }
}
