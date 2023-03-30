//package Div4.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Increasing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            Set<Integer> set=new HashSet<>();
            String []str=br.readLine().split(" ");
            for(int i=0;i<n;i++)
                set.add(Integer.parseInt(str[i]));
            if(set.size()==n)
                System.out.println("YES");
            else
                System.out.println("NO");

            t--;
        }
    }
}
