package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LoseIt {
    public static void main(String[] args) throws IOException {
        int []next=new int[50];
        next[4]=8;
        next[8]=15;
        next[15]=16;
        next[16]=23;
        next[23]=42;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(str[i]);
        Map<Integer, Integer> mp = new HashMap<>();
        int subseqs=0;
        //4 is always expected to come in the map and hence not managing its expectation
        for (int i = 0; i < n; i++) {
            if (a[i] != 4) {
                //checking if its expected
                if (!mp.containsKey(a[i]))
                    continue;
                //one subseq reached to its destination
                if (a[i] == 42)
                    subseqs += 1;
                //decreasing expectation by 1
                mp.put(a[i], mp.get(a[i]) - 1);
                //remvoing element from map if expectation reduces to zero
                if (mp.get(a[i]) == 0)
                    mp.remove(a[i]);
            }
            //increasing expectation of next element which can come
            if (!mp.containsKey(next[a[i]])) {
                mp.put(next[a[i]], 1);
            } else {
                mp.put(next[a[i]], mp.get(next[a[i]]) + 1);
            }
        }
        System.out.println(n-subseqs*6);
    }
}
