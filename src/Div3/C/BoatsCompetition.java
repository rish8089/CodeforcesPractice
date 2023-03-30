package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoatsCompetition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []hash=new int[n+1];
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                int val=Integer.parseInt(str[i]);
                if(hash[val]==0){
                    list.add(val);
                }
                hash[val]+=1;
            }
            //different numbers
            Map<Integer,Integer> mp=new HashMap<>();
            for(int i=0;i<list.size();i++){
                for(int j=i+1;j<list.size();j++){
                    int a=list.get(i);
                    int b=list.get(j);
                    if(mp.containsKey(a+b)){
                        mp.put(a+b,mp.get(a+b)+Integer.min(hash[a],hash[b]));
                    }else{
                        mp.put(a+b,Integer.min(hash[a],hash[b]));
                    }
                }
            }
            for(int i=0;i<list.size();i++){
                int a=list.get(i);
                if(mp.containsKey(a*2)){
                    mp.put(a*2,mp.get(a*2)+hash[a]/2);
                }else{
                    mp.put(a*2,hash[a]/2);
                }
            }
            int max=0;
            for(int e:mp.keySet()){
                if(max<mp.get(e)){
                    max=mp.get(e);
                }
            }
            System.out.println(max);
            t--;
        }
    }
}
