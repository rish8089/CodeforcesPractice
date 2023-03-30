package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivisibleConfusion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            int []a=new int[n];
            String []str=br.readLine().split(" ");
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int drops=0;
            boolean flag=true;
            for(int i=0;i<n;i++){
                int requiredDrops = getRequiredDrops(a[i], i+2);
                if(requiredDrops>drops){
                    flag=false;
                    break;
                }else
                    drops+=1;
            }
            System.out.println(flag?"YES":"NO");
            t--;
        }
    }

    private static int getRequiredDrops(int num, int i){
        int drops=0;
        while (i > 0 && num % i == 0) {
            drops++;
            i--;
        }
        if(i==0)
            return Integer.MAX_VALUE;
        else
            return drops;
    }
}
