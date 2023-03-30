package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternatingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int max=Integer.MIN_VALUE;
            long sum=0;
            for(int i=0;i<n;i++){
                if(i==0 || ((a[i-1]<0 && a[i]>0) || (a[i-1]>0 && a[i]<0))){
                    //start of the new segment
                    if (i != 0)
                        sum += max;
                    max=a[i];
                }else{
                    if(max<a[i])
                        max=a[i];
                }
            }
            sum+=max;
            System.out.println(sum);
            t--;
        }
    }
}
