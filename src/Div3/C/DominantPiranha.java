package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DominantPiranha {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int max=0;
            for(int i=0;i<n;i++){
                if(max<a[i])
                    max=a[i];
            }
            int idx=-1;
            for(int i=0;i<n;i++){
                if(a[i]==max){
                    if((i-1>=0 && i+1<n && a[i-1]<a[i] && a[i]>a[i+1]) || (i-1>=0 && a[i-1]<a[i]) || (i+1<n && a[i]>a[i+1])){
                        idx=i+1;
                        break;
                    }
                }
            }
            System.out.println(idx);
            t--;
        }
    }
}
