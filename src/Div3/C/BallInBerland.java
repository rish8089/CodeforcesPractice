package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BallInBerland {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String []abk=br.readLine().split(" ");
            int a=Integer.parseInt(abk[0]);
            int b=Integer.parseInt(abk[1]);
            int k=Integer.parseInt(abk[2]);
            String []astr=br.readLine().split(" ");
            String []bstr=br.readLine().split(" ");
            DancePair []dp=new DancePair[k];
            for(int i=0;i<k;i++){
                int av=Integer.parseInt(astr[i]);
                int bv=Integer.parseInt(bstr[i]);
                dp[i]=new DancePair(av,bv);
            }
            Map<Integer,Integer> hashav=new HashMap<>();
            Map<Integer,Integer> hashbv=new HashMap<>();
            for(int i=0;i<k;i++){
                if(hashav.containsKey(dp[i].av)) {
                    hashav.put(dp[i].av, hashav.get(dp[i].av)+1);
                }else{
                    hashav.put(dp[i].av, 1);
                }
            }
            for(int i=0;i<k;i++){
                if(hashbv.containsKey(dp[i].bv)) {
                    hashbv.put(dp[i].bv, hashbv.get(dp[i].bv)+1);
                }else{
                    hashbv.put(dp[i].bv, 1);
                }
            }
            long ans=0;
            for(int i=0;i<k;i++){
                int cntav=hashav.get(dp[i].av);
                int cntbv=hashbv.get(dp[i].bv);
                ans=ans+((k-1)-(cntav+cntbv-2));
            }
            System.out.println(ans/2);
            t--;
        }
    }
    private static class DancePair{
        int av;
        int bv;
        DancePair(int av,int bv){
            this.av=av;
            this.bv=bv;
        }
    }
}
