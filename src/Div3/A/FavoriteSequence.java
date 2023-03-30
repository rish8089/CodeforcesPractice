package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FavoriteSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            StringBuilder res=new StringBuilder();
            for(int i=0;i<n;i++){
                if(i%2==0){
                    res.append(a[i/2]).append(" ");
                }else{
                    res.append(a[n-1-i/2]).append(" ");
                }
            }
            System.out.println(res);
            t--;
        }

    }
}
