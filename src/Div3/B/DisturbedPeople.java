package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DisturbedPeople {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(str[i]);
        int cnt=0;
        for(int i=1;i<n-1;i++){
            if(a[i]==0){
                if(a[i-1]==1 && a[i+1]==1){
                    a[i+1]=0;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
