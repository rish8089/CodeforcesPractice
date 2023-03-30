//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class COOK82C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nm=br.readLine().split(" ");
        int n=Integer.parseInt(nm[0]);
        int m=Integer.parseInt(nm[1]);
        String []str=br.readLine().split(" ");
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++)
            pq.add(Long.parseLong(str[i]));
        List<Long> answers=new ArrayList<>();
        while(!pq.isEmpty()){
            long max=pq.poll();
            answers.add(max);
            max/=2;
            if(max>0)
                pq.add(max);
        }
        while(m>0){
            int q=Integer.parseInt(br.readLine());
            System.out.println(answers.get(q-1));
            m--;
        }
    }
}
