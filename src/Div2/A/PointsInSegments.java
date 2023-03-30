//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PointsInSegments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nm=br.readLine().split(" ");
        int n=Integer.parseInt(nm[0]);
        int m=Integer.parseInt(nm[1]);
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<n;i++){
            String []lr=br.readLine().split(" ");
            int l=Integer.parseInt(lr[0]);
            int r=Integer.parseInt(lr[1]);
            for(int j=l;j<=r;j++)
                s.add(j);

        }
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=m;i++){
            if(!s.contains(i))
                list.add(i);
        }
        System.out.println(list.size());
        for(int elem:list)
            System.out.print(elem+" ");
        System.out.println();
    }
}
