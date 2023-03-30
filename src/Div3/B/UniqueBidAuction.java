package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UniqueBidAuction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            Node []a=new Node[n];
            for(int i=0;i<n;i++) {
                a[i]=new Node();
                a[i].val=Integer.parseInt(str[i]);
                a[i].idx=i;
            }
            Arrays.sort(a,(o1,o2)->{
                return Integer.compare(o1.val,o2.val);
            });
            boolean found=false;
            for(int i=0;i<n;i++){
                int j=i;
                while(i+1<n && a[i+1].val==a[j].val)
                    i++;
                if(j==i){
                    found=true;
                    System.out.println(a[j].idx+1);
                    break;
                }
            }
            if(!found)
                System.out.println(-1);
            t--;
        }
    }
    private static class Node{
        int val;
        int idx;
    }
}
