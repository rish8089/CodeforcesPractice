package Div2.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArrayAndOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nk = br.readLine().split(" ");
            List<Integer> a = new ArrayList<>();
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                a.add(Integer.parseInt(str[i]));
            int remaining = n - 2 * k;
            Collections.sort(a);
            int minScore = 0;
            for (int i = 0; i < remaining; i++)
                minScore += a.get(i);
            Map<Integer, Integer> mp = new HashMap<>();
            for (int i = remaining; i < n; i++) {
                if (!mp.containsKey(a.get(i)))
                    mp.put(a.get(i), 1);
                else
                    mp.put(a.get(i), mp.get(a.get(i)) + 1);

            }
//            for(int i=remaining;i<n;i++){
//                if(set.contains(a.get(i))){
//                    Integer higher = set.higher(a.get(i));
//                    if(higher!=null){
//                        mp.put(higher, mp.get(higher)-1);
//                        if(mp.get(higher)==0) {
//                            mp.remove(higher);
//                            set.remove(higher);
//                        }
//                    }else{
//                        minScore+=1;
//                        mp.put(a.get(i),mp.get(a.get(i))-1);
//                    }
//                    mp.put(a.get(i),mp.get(a.get(i))-1);
//                    if(mp.get(a.get(i))==0) {
//                        mp.remove(a.get(i));
//                        set.remove(a.get(i));
//                    }
//                }
//            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (Integer key : mp.keySet()) {
                pq.add(mp.get(key));
            }
            while (pq.size() > 1) {
                int max1 = pq.poll();
                int max2 = pq.poll();
                max1-=1;
                max2-=1;
                if(max1>0)
                    pq.add(max1);
                if(max2>0)
                    pq.add(max2);
            }
            if (pq.size() == 1) {
                minScore += pq.peek() / 2;
            }
            System.out.println(minScore);
            t--;
        }
    }
}
