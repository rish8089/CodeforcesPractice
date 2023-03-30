//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PaprikaAndPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            List<Integer> a=new ArrayList<>();
            for(int i=0;i<n;i++)
                a.add(Integer.parseInt(str[i]));
            Map<Integer,Integer> mp=new HashMap<>();
            TreeSet<Integer> treeSet =new TreeSet<>();
            for(int i=0;i<n;i++){
                if(!mp.containsKey(a.get(i)))
                    mp.put(a.get(i),1);
                else
                    mp.put(a.get(i),mp.get(a.get(i))+1);
            }
            for(int i=0;i<n;i++)
                treeSet.add(a.get(i));
            boolean flag=true;
            int cnt=0;
            for(int i=n-1;i>=0;i--){
                int expected = i+1;
                if(mp.containsKey(expected)){
                    mp.put(expected, mp.get(expected)-1);
                    if(mp.get(expected)==0) {
                        mp.remove(expected);
                        treeSet.remove(expected);
                    }
                }else{
                    Integer last = treeSet.last();
                    if(last<2*expected+1){
                        flag=false;
                        break;
                    }
                    cnt+=1;
                    mp.put(last, mp.get(last)-1);
                    if(mp.get(last)==0){
                        mp.remove(last);
                        treeSet.remove(last);
                    }
                }
            }
            System.out.println(flag?cnt:-1);
            t--;
        }
    }
}
