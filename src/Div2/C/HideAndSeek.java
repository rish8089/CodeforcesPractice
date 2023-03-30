//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HideAndSeek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nk=br.readLine().split(" ");
        int n=Integer.parseInt(nk[0]);
        int k=Integer.parseInt(nk[1]);
        String []str=br.readLine().split(" ");
        int []a=new int[k];
        for(int i=0;i<k;i++)
            a[i]=Integer.parseInt(str[i]);
        Map<Integer, Set<Integer>> mp =new HashMap<>();
        for(int i=0;i<k;i++){
            Set<Integer> s;
            if(!mp.containsKey(a[i])){
                s=new HashSet<>();
                mp.put(a[i],s);
            }else
                s=mp.get(a[i]);

            if(a[i]-1>=1) {
                if (!s.contains(a[i] - 1) && mp.containsKey(a[i] - 1)) {
                    s.add(a[i] - 1);
                }
            }
            if(a[i]+1<=n) {
                if (!s.contains(a[i]+1) && mp.containsKey(a[i]+1)){
                    s.add(a[i]+1);
                }
            }
        }
        long cnt = 3*n-2;
        for(Integer s:mp.keySet()){
            int ss =mp.get(s).size();
            cnt-=1+ss;
        }
        System.out.println(cnt);
    }
}
