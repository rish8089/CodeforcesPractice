package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class PolycarpTraining {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(str[i]);
        TreeMap<Integer,Integer> mp=new TreeMap<>();
        for(int i=0;i<n;i++){
            if(mp.containsKey(a[i])){
                mp.put(a[i],mp.get(a[i])+1);
            }else{
                mp.put(a[i],1);
            }
        }
        int cnt=0;
        for(int i=1;i<=n;i++){
            //checking for ith day
            Map.Entry<Integer,Integer> e=mp.ceilingEntry(i);
            if(e!=null){
                cnt+=1;
                if(e.getValue()==1){
                    mp.remove(e.getKey());
                }else{
                    mp.put(e.getKey(), e.getValue()-1);
                }
            }else
                break;
        }
        System.out.println(cnt);
    }
}
