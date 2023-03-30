//package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SquaresAndCubes {
    private static int LIM=1000000000;
    public static void main(String[] args) throws IOException {
        Set<Integer> set=new TreeSet<>();
        long x=1;
        while(x*x<=LIM){
            set.add((int)(x*x));
            x+=1;
        }
        x=1;
        while(x*x*x<=LIM){
            set.add((int)(x*x*x));
            x+=1;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            int cnt=0;
            for(Integer elem:set){
                if(elem>n){
                    break;
                }
                cnt++;
            }
            System.out.println(cnt);
            t--;
        }
    }
}
