//package Div4.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Orray {
    public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
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
                    mp.put(a[i], mp.get(a[i])+1);
            }
            List<Integer> res=new ArrayList<>();
            int orres=0;
            for(int i=1;i<=31;i++){
                int max=Integer.MIN_VALUE;
                int element=-1;
                for(int j=0;j<n;j++){
                    if(mp.get(a[j])>0) {
                        if (max < (orres | a[j])) { 
                            max = orres | a[j];
                            element = a[j];
                        }
                    }
                }
                if(element!=-1) {
                    mp.put(element, mp.get(element) - 1);
                    orres = max;
                    res.add(element);
                }
            }
            Set<Integer> keys=mp.keySet();
            for(Integer key:keys){
                int cnt=mp.get(key);
                for(int i=1;i<=cnt;i++){
                    res.add(key);
                }
            }
            StringBuilder output=new StringBuilder();
            for(int i=0;i<res.size();i++)
                output.append(res.get(i)).append(" ");
            System.out.println(output);
            t--;
        }
    }
}
