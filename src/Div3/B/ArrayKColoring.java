package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArrayKColoring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nk=br.readLine().split(" ");
        int n=Integer.parseInt(nk[0]);
        int k=Integer.parseInt(nk[1]);
        String []str=br.readLine().split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(str[i]);
        }
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            if(mp.containsKey(a[i])){
                List<Integer> list=mp.get(a[i]);
                list.add(i);
                mp.put(a[i], list);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                mp.put(a[i],list);
            }
        }
        int []color=new int[n];
        boolean flag=true;
        int cnt=0;
        for(Map.Entry<Integer,List<Integer>> entry:mp.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() > k) {
                flag = false;
                break;
            }
            for(Integer e:list){
                color[e]=cnt%k+1;
                cnt++;
            }
        }
        if(!flag || cnt<k){
            System.out.println("NO");
        }else{
            System.out.println("YES");
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<n;i++)
                ans.append(color[i]).append(" ");
            System.out.println(ans);
        }
    }
}
