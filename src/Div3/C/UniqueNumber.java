package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UniqueNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int []d={1,2,3,4,5,6,7,8,9};
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=1;i<=511;i++){
            int idx=0;
            int j=i;
            int sum=0;
            int num=0;
            while(j>0){
                int temp=j%2;
                if(temp==1){
                    sum=sum+d[idx];
                    num=num*10+d[idx];
                }
                j/=2;
                idx++;
            }
            if(!mp.containsKey(sum) || num<mp.get(sum)){
                mp.put(sum,num);
            }
        }
        while(t>0){
            int x=Integer.parseInt(br.readLine());
            if(!mp.containsKey(x))
                System.out.println(-1);
            else
                System.out.println(mp.get(x));
            t--;
        }
    }
}
