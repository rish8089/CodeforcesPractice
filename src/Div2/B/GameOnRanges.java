//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameOnRanges {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            List<Node> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                String []lr=br.readLine().split(" ");
                list.add(new Node(Integer.parseInt(lr[0]), Integer.parseInt(lr[1])));
            }
            Collections.sort(list, (n1,n2)->{
                return Integer.compare(n2.r-n2.l+1, n1.r-n1.l+1);
            });
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<n;i++){
                int l=list.get(i).l;
                int r=list.get(i).r;
                //trying to finds its fragments
                Node frag;
                frag=null;
                for (int j = i + 1; j < n; j++) {
                    if (l <= list.get(j).l && list.get(j).r <= r) {
                        frag = list.get(j);
                        break;

                    }
                }
                ans.append(l).append(" ").append(r).append(" ");
                if(frag != null) {
                    int len = frag.r-frag.l+1;
                    if(len == r-l){
                        if(frag.r<r)
                            ans.append(r);
                        else
                            ans.append(l);
                    }else{
                        if(frag.r==r)
                            ans.append(frag.l-1);
                        else
                            ans.append(frag.r+1);
                    }
                }
                else
                    ans.append(r);
                ans.append("\n");
            }
            System.out.print(ans);
            t--;
        }
    }
    private static class Node{
        int l;
        int r;
        Node(int l, int r){
            this.l=l;
            this.r=r;
        }
    }
}
