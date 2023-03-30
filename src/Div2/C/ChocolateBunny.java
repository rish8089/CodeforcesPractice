//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChocolateBunny {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int []p=new int[n];
        int x=0;
        for(int i=1;i<n;i++){
            int y=i;
            System.out.format("? %d %d\n? %d %d\n", x + 1, y + 1, y + 1, x + 1);
            int ans1=Integer.parseInt(br.readLine());
            int ans2=Integer.parseInt(br.readLine());
            if(ans1>ans2){
                p[x]=ans1;
                x=y;
            }else{
                p[y]=ans2;
            }
        }
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < n; i++)
            sum -= p[i];
        p[x] = sum;
        StringBuilder ans=new StringBuilder();
        ans.append("! ");
        for(int i=0;i<n;i++){
            ans.append(p[i]).append(" ");
        }
        System.out.println(ans);
    }
}
