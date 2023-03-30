package Div4.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TeleportersHard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nc=br.readLine().split(" ");
            int n=Integer.parseInt(nc[0]);
            int c=Integer.parseInt(nc[1]);
            String []str=br.readLine().split(" ");
            Integer []a=new Integer[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            Node []arr=new Node[n];
            for(int i=0;i<n;i++){
                if(i+1<=n-i) {
                    arr[i]=new Node(a[i]+i+1,i);
                }else{
                    arr[i]=new Node(a[i]+n-i,n+i);
                }
            }
            boolean []visited=new boolean[n];
            Arrays.sort(arr, (n1,n2)->{
                return Integer.compare(n1.val, n2.val);
            });
            boolean leftMovement = false;
            int tempc=c;
            int cnt=0;
            for(int i=0;i<n;i++){
                if(c>=arr[i].val){
                    c-=a[i];
                    if(arr[i].idx<n)
                        leftMovement=true;
                   cnt++;
                }else
                    break;
            }
            if(leftMovement)
                System.out.println(cnt);
            else{

            }
            t--;
        }
    }
    static class Node{
        int val;
        int idx;
        Node(int val, int idx){
            this.val=val;
            this.idx=idx;
        }
    }
}
