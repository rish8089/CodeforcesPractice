//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class NumbersOnWhiteboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
            for(int i=1;i<=n;i++)
                pq.add(i);
            StringBuilder ans=new StringBuilder();
            while(pq.size()>1){
                int a=pq.poll();
                int b=pq.poll();
                ans.append(a).append(" ").append(b).append("\n");
                pq.add((a+b)%2==0?(a+b)/2:(a+b)/2+1);
            }
            System.out.println(pq.peek());
            System.out.println(ans);
            t--;
        }
    }
}
