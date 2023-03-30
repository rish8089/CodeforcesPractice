//package Div4.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

public class Scuza {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []sq=br.readLine().split(" ");
            int s=Integer.parseInt(sq[0]);
            int q=Integer.parseInt(sq[1]);
            int []a=new int[s];
            String []str=br.readLine().split(" ");
            for(int i=0;i<s;i++){
                a[i]=Integer.parseInt(str[i]);
            }
            int []k=new int[q];
            str=br.readLine().split(" ");
            for(int i=0;i<q;i++)
                k[i]=Integer.parseInt(str[i]);
            HashMap<Integer,Long> mp=new HashMap<>();
            int maxStepHeight=0;
            mp.put(0,0L);//people with height from 0 to max can cover 0 height
            for(int i=0;i<s;i++){
                if(maxStepHeight<a[i]){
                    mp.put(a[i], mp.get(maxStepHeight)+a[i]);
                    maxStepHeight=a[i];
                }else{
                    mp.put(maxStepHeight, mp.get(maxStepHeight)+a[i]);
                }
            }
            StringBuilder ans=new StringBuilder();
            TreeSet<Integer> tSet=new TreeSet<>(mp.keySet());
            for(int i=0;i<q;i++){
                Integer closestStepHeight=tSet.floor(k[i]);
                if(closestStepHeight==null)
                    ans.append(-1);
                else
                    ans.append(mp.get(closestStepHeight));
                ans.append(" ");
            }
            System.out.println(ans);
            t--;
        }
    }
}
