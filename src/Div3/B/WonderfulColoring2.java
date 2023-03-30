package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WonderfulColoring2 {
    private static final int LIM=200000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0){
            String []nk=br.readLine().split(" ");
            int n=Integer.parseInt(nk[0]);
            int k=Integer.parseInt(nk[1]);
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int cnt=0;
            Map<Integer, List<Integer>> mp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                List<Integer> list;
                if (!mp.containsKey(a[i])) {
                    list = new ArrayList<>();
                } else {
                    list = mp.get(a[i]);
                }
                if (list.size() < k) {
                    list.add(i);
                    mp.put(a[i], list);
                    cnt += 1;
                }
            }
            cnt = (cnt/k)*k;
            int []color=new int[n];
            for (int i = 1, j = 1; i <= LIM && j<=cnt; i++) {
                if(mp.containsKey(i)){
                    List<Integer> list=mp.get(i);
                    for(int l=0;l<list.size() && j<=cnt;l++,j++){
                        int idx=list.get(l);
                        color[idx]= j%k==0?k:j%k;
                    }
                }
            }
            StringBuilder res=new StringBuilder();
            for(int i=0;i<n;i++)
                res.append(color[i]).append(" ");
            System.out.println(res);
            t--;
        }
    }
}
