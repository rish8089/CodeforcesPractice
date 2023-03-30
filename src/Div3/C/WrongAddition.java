//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WrongAddition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []as=br.readLine().split(" ");
            long a=Long.parseLong(as[0]);
            long s=Long.parseLong(as[1]);
            boolean flag=true;
            List<Integer> l = new ArrayList<>();
            while(a>0 && s>0){
                long x1=a%10;
                a/=10;
                long x2=s%10;
                s/=10;
                if(x1<=x2)
                    l.add((int)(x2-x1));
                else{
                    x2=(s%10)*10+x2;
                    s/=10;
                    if(x1<=x2 && x2-x1<=9){
                        l.add((int)(x2-x1));
                    }else{
                        flag=false;
                        break;
                    }
                }
            }
            if(flag && a==0){
                long diff=s-a;
                while(diff>0){
                    l.add((int)(diff%10));
                    diff/=10;
                }
                int idx=l.size()-1;
                while(idx>=0 && l.get(idx)==0)
                    idx--;
                for(int i=idx;i>=0;i--)
                    System.out.print(l.get(i));
                System.out.println();
            }else{
                System.out.println(-1);
            }
            t--;
        }
    }
}
