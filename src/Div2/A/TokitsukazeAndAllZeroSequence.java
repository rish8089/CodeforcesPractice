//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TokitsukazeAndAllZeroSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            int []a=new int[n];
            String []str=br.readLine().split(" ");
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            Map<Integer,Integer> mp=new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (mp.containsKey(a[i]))
                    mp.put(a[i], mp.get(a[i]) + 1);
                else
                    mp.put(a[i], 1);
            }
            int operations = 0;
            int nonZeroUnique = 0;
            for(Integer key : mp.keySet()){
                if(key != 0) {
                    int cnt = mp.get(key);
                    if(cnt == 1) {
                        nonZeroUnique +=1;
                    }else{
                        operations += cnt;
                    }
                }
            }
            int zeroCount = mp.getOrDefault(0, 0);
            if(zeroCount > 0 || nonZeroUnique + zeroCount < n) {
                operations += nonZeroUnique;
            } else {
                operations += nonZeroUnique + 1;
            }
            System.out.println(operations);
            t--;
        }
    }
}
