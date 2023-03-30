package Div3.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CanYouReachTheEnd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        //StringBuilder ans=new StringBuilder();
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<Integer,Integer> mp=new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] ab = br.readLine().split(" ");
                int a = Integer.parseInt(ab[0]);
                int b = Integer.parseInt(ab[1]);
                if(mp.containsKey(a+b))
                    mp.put(a+b,mp.get(a+b)+1);
                else
                    mp.put(a+b,1);
            }
            boolean flag=true;
            for(int k:mp.keySet()){
                int v=mp.get(k);
                int diff=abs(k-(n+1));//at how much distance it is from middle diagonal
                if(v==n-diff){
                    flag=false;
                    break;
                }
            }
            System.out.println(flag?"YES":"NO");
            t--;
        }
        //System.out.println(ans);
    }

    private static int abs(int x){
        return x<0?-x:x;
    }


}
