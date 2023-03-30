//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class IntegerDiversity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            Map<Integer,Integer> mp=new HashMap<>();
            for(int i=0;i<n;i++){
                if(!mp.containsKey(a[i]))
                    mp.put(a[i],1);
                else
                    mp.put(a[i],mp.get(a[i])+1);
            }
            int cnt=mp.size();
            for(Integer elem:mp.keySet()){
                if(elem!=0 && mp.containsKey(elem)){
                    if(mp.get(elem)>1 && !mp.containsKey(-elem))
                        cnt++;
                }
            }
            System.out.println(cnt);
            t--;
        }
    }
}
