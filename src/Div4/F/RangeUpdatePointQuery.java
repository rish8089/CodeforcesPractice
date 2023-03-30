//package Div4.F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RangeUpdatePointQuery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nq=br.readLine().split(" ");
            int n=Integer.parseInt(nq[0]);
            int q=Integer.parseInt(nq[1]);
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            SegmentTree root=SegmentTree.buildSegmentTree(0,n-1);
            while(q>0){
                str=br.readLine().split(" ");
                int c=Integer.parseInt(str[0]);
                if(c==1){
                    int s=Integer.parseInt(str[1]);
                    int e=Integer.parseInt(str[2]);
                    root.update(0,n-1,s-1,e-1);
                }else{
                    int idx=Integer.parseInt(str[1]);
                    int noOfUpdates = root.get(0,n-1,idx-1);
                    System.out.println(reduce(a[idx-1], noOfUpdates));
                }
                q--;
            }
            t--;
        }
    }
    private static int reduce(int val, int n){
        for(int i=1;i<=n;i++){
            int sumOfDigits=0;
            while(val>0){
                sumOfDigits+=val%10;
                val/=10;
            }
            val=sumOfDigits;
            if(val>=1 && val<=9)
                break;
        }
        return val;
    }
}

class SegmentTree {
    SegmentTree left;
    SegmentTree right;
    int val;
    public static SegmentTree buildSegmentTree(int s, int e){
        SegmentTree root=new SegmentTree();
        if(s<e) {
            root.left = buildSegmentTree(s,(s+e)/2);
            root.right = buildSegmentTree((s+e)/2+1,e);
        }
        return root;
    }
    public void update(int s, int e, int qs, int qe){
        if(s==qs && e==qe) {
            this.val+=1;
            return;
        }
        int mid=(s+e)/2;
        if(qs<=mid){
            this.left.update(s,mid,qs,Math.min(qe,mid));
        }
        if(qe>mid){
            this.right.update(mid+1,e,Math.max(mid+1,qs),qe);
        }
    }
    public int get(int s, int e, int idx){
        if(s==e){
            return this.val;
        }
        int mid=(s+e)/2;
        if(idx<=mid)
            return this.val+this.left.get(s, mid, idx);
        else
            return this.val+this.right.get(mid+1,e,idx);
    }
}
