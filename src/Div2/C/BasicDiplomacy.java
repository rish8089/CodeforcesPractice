package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BasicDiplomacy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nm=br.readLine().split(" ");
            int n=Integer.parseInt(nm[0]);
            int m=Integer.parseInt(nm[1]);
            int half=(m+1)/2;
            List<Set<Integer>> days=new ArrayList<>();
            for(int i=0;i<m;i++){
                String []str=br.readLine().split(" ");
                int k=Integer.parseInt(str[0]);
                Set<Integer> friends = new LinkedHashSet<>();
                days.add(friends);
                for(int j=0;j<k;j++)
                    friends.add(Integer.parseInt(str[j+1]));
            }
            int []cnt=new int[n+1];
            for (Set<Integer> friends : days) {
                for(Integer friend:friends)
                    cnt[friend]++;
            }
            //find a friend that has cnt greater than half
            int majorityFriend = -1;
            for (int i = 1; i <= n; i++) {
                if (cnt[i] > half) {
                    majorityFriend = i;
                    break;
                }
            }

            int []res=new int[m];
            Arrays.fill(res,0);
            if (majorityFriend != -1) {
                List<Integer> majorityFriendDays = new ArrayList<>();
                for (int i = 0; i < days.size(); i++) {
                    Set<Integer> s = days.get(i);
                    if (s.contains(majorityFriend)) {
                        majorityFriendDays.add(i);
                    }
                }
                majorityFriendDays.sort((d1, d2) -> {
                    return Integer.compare(days.get(d1).size(), days.get(d2).size());
                });
                int daym = majorityFriendDays.get(half);
                if (days.get(daym).size() == 1) {
                    System.out.println("NO");
                    t--;continue;
                }
                for (int i = 0; i < majorityFriendDays.size(); i++) {
                    if (i < half) {
                        res[majorityFriendDays.get(i)] = majorityFriend;
                    }
                    else {
                        Set<Integer> s = days.get(majorityFriendDays.get(i));
                        s.remove(majorityFriend);
                    }

                }
            }

            for (int i = 0; i < days.size(); i++) {
                if (res[i] == 0) {
                    Set<Integer> s = days.get(i);
                    res[i]=s.iterator().next();
                }
            }
            System.out.println("YES");
            for(int i=0;i<m;i++)
                System.out.print(res[i]+" ");
            System.out.println();
            t--;
        }
    }
}
