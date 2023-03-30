//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PinkiePieEatsPattyCakes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            Map<Integer,Integer> mp =new HashMap<>();
            for(int i=0;i<n;i++){
                if(!mp.containsKey(a[i]))
                    mp.put(a[i],1);
                else
                    mp.put(a[i],mp.get(a[i])+1);
            }
            int maxCnt=0;
            for(Integer key:mp.keySet()){
                if(maxCnt<mp.get(key)){
                    maxCnt=mp.get(key);
                }
            }
            int ans=0;
            int cnt=0;
            for(Integer key:mp.keySet()){
                int val=mp.get(key);
                if(val==maxCnt)
                    ans+=1;
                else
                    cnt+=val;
            }
            System.out.println(ans+cnt/(maxCnt-1)-1);
            t--;
        }
    }
}