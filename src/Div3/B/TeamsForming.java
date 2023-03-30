package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TeamsForming {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(str[i]);
        Arrays.sort(a);
        int ans=0;
        for(int i=0;i<n;i+=2){
            ans+=a[i+1]-a[i];
        }
        System.out.println(ans);
    }
}
