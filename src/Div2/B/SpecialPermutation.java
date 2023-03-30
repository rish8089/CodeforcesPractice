//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SpecialPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nab = br.readLine().split(" ");
            int n = Integer.parseInt(nab[0]);
            int a = Integer.parseInt(nab[1]);
            int b = Integer.parseInt(nab[2]);
            List<Integer> ans=new ArrayList<>();
            int cnt=n/2-1;
            int i=n;
            while(cnt>0){
                if(i!=a && i!=b){
                    ans.add(i);
                    cnt--;
                }
                i--;
            }
            if(a>i)
                System.out.println(-1);
            else {
                if(b>=i || (a==i && b==i-1)){
                    ans.add(a);
                    ans.add(b);
                    while(i>=1){
                        if(i!=a && i!=b){
                            ans.add(i);
                        }
                        i--;
                    }
                    for(Integer elem:ans)
                        System.out.print(elem+" ");
                    System.out.println();
                }
                else
                    System.out.println(-1);
            }
            t--;
        }
    }
}
