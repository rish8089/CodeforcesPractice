//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BerlandMusic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            String votes = br.readLine();
            int dislikes = 0;
            for (int i = 0; i < n; i++) {
                if (votes.charAt(i) == '0')
                    dislikes += 1;
            }
            List<Node> dislikeNodes=new ArrayList<>();
            List<Node> likeNodes=new ArrayList<>();
            for(int i=0;i<n;i++){
               if(votes.charAt(i)=='0'){
                   dislikeNodes.add(new Node(a[i], i));
               }else{
                   likeNodes.add(new Node(a[i],i));
               }
            }
            Collections.sort(dislikeNodes, (n1,n2)->{
                return Integer.compare(n1.val,n2.val);
            });
            Collections.sort(likeNodes, (n1,n2)->{
                return Integer.compare(n1.val,n2.val);
            });
            for(int i=0;i<dislikeNodes.size();i++){
                Node dn=dislikeNodes.get(i);
                a[dn.idx] = i+1;
            }
            for(int i=0;i<likeNodes.size();i++){
                Node ln=likeNodes.get(i);
                a[ln.idx] = dislikes+i+1;
            }
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<n;i++)
                ans.append(a[i]).append(" ");
            System.out.println(ans);
            t--;
        }
    }
    private static class Node{
        int val;
        int idx;
        Node(int v,int i){
            this.val=v;
            this.idx=i;
        }
    }
}
