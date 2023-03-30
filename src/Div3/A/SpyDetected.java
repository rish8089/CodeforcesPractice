//package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpyDetected {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=a[i];
            }
            for(int i=1;i<n;i++){
                if(a[i] != a[0]){
                    //either a[i] or a[0] is the one
                    if((n-1)*a[0]+a[i] == sum) {
                        System.out.println(i+1);
                    }else{
                        System.out.println(1);
                    }
                    break;
                }
            }
            t--;
        }
    }
}
