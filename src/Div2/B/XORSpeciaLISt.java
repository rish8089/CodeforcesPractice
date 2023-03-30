//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XORSpeciaLISt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            if(n%2==0){
                System.out.println("YES");
            }else{
                System.out.println(isStrictlySorted(a)?"NO":"YES");
            }
            t--;
        }
    }
    private static boolean isStrictlySorted(int []a){
        for(int i=0;i<a.length-1;i++){
            if(a[i]>=a[i+1])
                return false;
        }
        return true;
    }
}
