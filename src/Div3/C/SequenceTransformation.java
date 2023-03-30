package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SequenceTransformation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            Map<Integer,List<Integer>> mp=new HashMap<>();
            for(int i=0;i<n;i++){
                if(!mp.containsKey(a[i])){
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    mp.put(a[i],list);
                }else{
                    List<Integer> list=mp.get(a[i]);
                    list.add(i);
                }
            }
            Set<Integer> keySet= mp.keySet();
            int ans=-1;
            for(int key:keySet){
                List<Integer> list=mp.get(key);
                int cnt=0;
                for(int i=0;i<list.size();i++){
                    if(i==0){
                        if(list.get(i)>0)
                            cnt+=1;
                    }else{
                        if(list.get(i)-list.get(i-1)>1)
                            cnt+=1;
                    }
                }
                if(n-1-list.get(list.size()-1)>0)
                    cnt+=1;
                if(ans==-1 || ans>cnt)
                    ans=cnt;
            }
            System.out.println(ans);
            t--;
        }

    }
}
