package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumOfCubes {
    private static int LIM=10000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        List<Long> list=new ArrayList<>();
        for(int i=1;i<=LIM;i++) {
            list.add(calculateCube(i));
        }
        Collections.sort(list);
        while(t>0){
            long x=Long.parseLong(br.readLine());
            boolean flag=false;
            for(int i=0;i<LIM;i++){
                long element = list.get(i);
                if(element<x){
                    int pos = Collections.binarySearch(list, x-element);
                    if(pos>=0){
                        flag=true;
                    }
                }
            }
            System.out.println(flag?"YES":"NO");
            t--;
        }

    }
    private static long calculateCube(long x){
        return x*x*x;
    }
}
