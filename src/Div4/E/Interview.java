//package Div4.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interview {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            int []a=new int[n];
            String []str=br.readLine().split(" ");
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int []prefix=new int[n];
            for(int i=0;i<n;i++){
                if(i==0)
                    prefix[i]=a[i];
                else
                    prefix[i]=prefix[i-1]+a[i];
            }
            int u=1;
            int v=n;
            while(u<v){
                int mid=(u+v)/2;
                if(checkIfLeftContainsSpecialStone(u,mid,prefix,br)){
                    v=mid;
                }else{
                    u=mid+1;
                }
            }
            System.out.println("! " + u);
            t--;
        }
    }
    private static boolean checkIfLeftContainsSpecialStone(int l, int r, int []prefix, BufferedReader br) throws IOException {
        System.out.print("? " + (r - l + 1) + " ");
        for (int i = l; i <= r; i++)
            System.out.print(i + " ");
        System.out.println();
        int ans=Integer.parseInt(br.readLine());
        int sum=prefix[r-1]-(l>1?prefix[l-2]:0);
        return ans>sum;
    }
}
