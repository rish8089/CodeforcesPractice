//package Div4.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Coprime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            Map<Integer,Integer> mp=new HashMap<>();
            for(int i=0;i<n;i++){
              mp.put(a[i],i);
            }
            int maxSum=0;
            Set<Integer> set = mp.keySet();
            for(Integer num1:set){
                for(Integer num2:set){
                    int gcd=gcd(num1,num2);
                    if(gcd==1){
                       if(maxSum<mp.get(num1)+mp.get(num2)+2)
                           maxSum=mp.get(num1)+mp.get(num2)+2;
                    }
                }
            }
            System.out.println(maxSum==0?-1:maxSum);
            t--;
        }
    }
    private static int gcd(int a,int b){
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }
}
