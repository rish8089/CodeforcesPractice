package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeIt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(str[i]);
            }
            int []rem=new int[3];
            for(int i=0;i<n;i++){
                rem[a[i]%3]++;
            }
            int ans=0;
            if(rem[1]>rem[2]){
                ans=rem[2]+(rem[1]-rem[2])/3;
            }else{
                ans=rem[1]+(rem[2]-rem[1])/3;
            }
            System.out.println(ans+rem[0]);
            t--;
        }
    }
}
