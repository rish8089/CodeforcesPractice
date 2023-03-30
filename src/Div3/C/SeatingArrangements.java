package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SeatingArrangements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            String[] str = br.readLine().split(" ");
            int[] a = new int[m];
            for (int i = 0; i < m; i++)
                a[i] = Integer.parseInt(str[i]);
            int[] seat = new int[m];
            allotSeatNumbers(a, seat, m);
            System.out.println(calculateInconvenience(seat, m));
            t--;
        }
    }
    private static void allotSeatNumbers(int []a,int []seat, int m){
        TreeMap<Integer,List<Integer>> mp=new TreeMap<>();
        for(int i=0;i<m;i++){
            if(mp.containsKey(a[i])){
                List<Integer> list=mp.get(a[i]);
                list.add(i);
                mp.put(a[i],list);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                mp.put(a[i],list);
            }
        }
        int cnt=0;
        for(Integer k:mp.keySet()){
            List<Integer> list=mp.get(k);
            for(int i=0;i<list.size();i++){
                int idx=list.get(i);
                seat[idx]=cnt+list.size()-i;
            }
            cnt+=list.size();
        }
    }

    private static int calculateInconvenience(int []seat, int m){
        int totalInconvenience=0;
        TreeSet<Integer> s=new TreeSet<>();
        for(int i=0;i<m;i++){
            int seatNo=seat[i];
            List<Integer> list=new ArrayList<>(s);
            for(int e:list){
                if(e<seatNo)
                    totalInconvenience+=1;
                else
                    break;
            }
            s.add(seatNo);
        }
        return totalInconvenience;
    }
}
