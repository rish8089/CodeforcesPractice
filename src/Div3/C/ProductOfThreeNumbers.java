package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProductOfThreeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            int m=n;
            List<PrimeDivisor> list=new ArrayList<>();
            for(int i=2;i*i<=n;i++){
                int cnt=0;
                while(n%i==0){
                    n=n/i;
                    cnt+=1;
                }
                if(cnt>0){
                    list.add(new PrimeDivisor(i,cnt));
                }

            }
            if(n>1){
                list.add(new PrimeDivisor(n, 1));
            }
            n=m;
            if(list.size()>=3) {
                System.out.println("YES");
                PrimeDivisor pd1=list.get(0);
                PrimeDivisor pd2=list.get(1);
                System.out.format("%d %d %d\n", pd1.val, pd2.val, n / (pd1.val * pd2.val));
            }else if(list.size()>=2){
                PrimeDivisor pd1=list.get(0);
                PrimeDivisor pd2=list.get(1);
                if((pd1.cnt==1 && pd2.cnt==1) || (pd1.cnt==1 && pd2.cnt==2) || (pd1.cnt==2 && pd2.cnt==1))
                    System.out.println("NO");
                else{
                    System.out.println("YES");
                    System.out.format("%d %d %d\n", pd1.val, pd2.val, n / (pd1.val * pd2.val));
                }
            }else{
                PrimeDivisor pd1=list.get(0);
                if(pd1.cnt<6)
                    System.out.println("NO");
                else{
                    System.out.println("YES");
                    System.out.format("%d %d %d\n", pd1.val, pd1.val*pd1.val, n/(pd1.val*pd1.val*pd1.val));
                }
            }
            t--;
        }

    }
    private static class PrimeDivisor{
        int val;
        int cnt;
        PrimeDivisor(int val, int cnt){
            this.val=val;
            this.cnt=cnt;
        }
    }
}
