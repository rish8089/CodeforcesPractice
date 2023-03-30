//package Div3.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WeightsAssignmentForTreeEdges {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []ancestors=new int[n+1];
            for(int i=0;i<n;i++)
                ancestors[i]=Integer.parseInt(str[i]);
            str = br.readLine().split(" ");
            int []distanceOrder = new int[n];
            for(int i=0;i<n;i++)
                distanceOrder[i]=Integer.parseInt(str[i]);
            int root=-1;
            for(int i=0;i<n;i++){
                if(ancestors[i]==i+1){
                    root=i+1;
                    break;
                }
            }
            assert(root!=-1);
            Map<Integer, List<Integer>> mp=new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (i + 1 != root) {
                    List<Integer> list;
                    if (!mp.containsKey(ancestors[i])) {
                        list = new ArrayList<>();
                        list.add(i + 1);
                        mp.put(ancestors[i], list);
                    } else {
                        list = mp.get(ancestors[i]);
                        list.add(i + 1);
                    }
                }
            }
            int []w=new int[n];
            int []d=new int[n];//total distance from root
            Set<Integer> s=new HashSet<>();
            s.add(root);
            int lastDistance = 0;
            w[root-1]=0;
            boolean flag=true;
            for(int i=0;i<n;i++){
                if(!s.contains(distanceOrder[i])){
                    flag=false;
                    break;
                }else {
                    //put all children of distanceOrder[i]
                    if(mp.containsKey(distanceOrder[i])){
                        List<Integer> list=mp.get(distanceOrder[i]);
                        s.addAll(list);
                    }
                    //weight assignment
                    if (distanceOrder[i] != root) {
                        //aiming for lastDistance+1
                        lastDistance = lastDistance + 1;
                        w[distanceOrder[i]-1] = lastDistance - d[ancestors[distanceOrder[i]-1]-1];
                        d[distanceOrder[i]-1] = lastDistance;
                    }
                }
            }
            if(!flag)
                System.out.println(-1);
            else{
                StringBuilder ans=new StringBuilder();
                for(int i=0;i<n;i++)
                    ans.append(w[i]).append(" ");
                System.out.println(ans);
            }
            t--;
        }
    }
}
