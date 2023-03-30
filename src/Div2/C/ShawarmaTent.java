//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShawarmaTent {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nsxsy=br.readLine().split(" ");
        int n=Integer.parseInt(nsxsy[0]);
        int sx=Integer.parseInt(nsxsy[1]);
        int sy=Integer.parseInt(nsxsy[2]);
        Node []p=new Node[n];
        for(int i=0;i<n;i++){
            String []str=br.readLine().split(" ");
            p[i]=new Node();
            p[i].x=Integer.parseInt(str[0]);
            p[i].y=Integer.parseInt(str[1]);
        }
        int above = 0, down = 0;
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (p[i].y > sy)
                above += 1;
            else if (p[i].y < sy)
                down += 1;
            if (p[i].x > sx) {
                right += 1;
            } else if (p[i].x < sx)
                left += 1;
        }
        int max = Integer.max(Integer.max(above, down), Integer.max(left, right));
        System.out.println(max);
        if(max==above){
            System.out.format("%d %d\n",sx,sy+1);
        }else if(max==down){
            System.out.format("%d %d\n",sx,sy-1);
        }else if(max==left){
            System.out.format("%d %d\n",sx-1,sy);
        }else{
            System.out.format("%d %d\n",sx+1,sy);
        }
    }
    private static class Node{
        int x;
        int y;
    }
}
