package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberOfPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder res=new StringBuilder();
        while(t>0){
            String []nlr=br.readLine().split(" ");
            int n=Integer.parseInt(nlr[0]);
            int l=Integer.parseInt(nlr[1]);
            int r=Integer.parseInt(nlr[2]);
            List<Integer> a=new ArrayList<>();
            String []str=br.readLine().split(" ");
            for(int i=0;i<n;i++)
                a.add(Integer.parseInt(str[i]));
            Collections.sort(a);
            long ans=0;
            for(int i=0;i<n-1;i++){
                int lidx = getIndexOfElementGreaterThanEqualTo(a, i + 1, n - 1, l-a.get(i));
                int ridx = getIndexOfElementLesserThanEqualTo(a, i + 1, n - 1, r - a.get(i));
                if (lidx != -1 && ridx != -1) {
                    ans += ridx - lidx + 1;
                }
            }
            res.append(ans).append("\n");
            t--;
        }
        System.out.println(res);
    }

    private static int getIndexOfElementGreaterThanEqualTo(List<Integer> a, int si, int se, int input){
        int u=si;
        int v=se;
        int ans=-1;
        while(u<=v){
            int mid=(u+v)/2;
            if(a.get(mid)>=input){
                v=mid-1;
                ans=mid;
            }else{
                u=mid+1;
            }
        }
        return ans;
    }

    private static int getIndexOfElementLesserThanEqualTo(List<Integer> a, int si, int se, int input){
        int u=si;
        int v=se;
        int ans=-1;
        while(u<=v){
            int mid=(u+v)/2;
            if(a.get(mid)<=input){
                u=mid+1;
                ans=mid;
            }else{
                v=mid-1;
            }
        }
        return ans;
    }
}
