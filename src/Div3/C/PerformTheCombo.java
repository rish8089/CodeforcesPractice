//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PerformTheCombo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nm=br.readLine().split(" ");
            int n=Integer.parseInt(nm[0]);
            int m=Integer.parseInt(nm[1]);
            String s=br.readLine();
            String []str=br.readLine().split(" ");
            int []p=new int[m];
            for(int i=0;i<m;i++)
                p[i]=Integer.parseInt(str[i]);
            Arrays.sort(p);
            int []buttonPresses = new int[n];
            for(int i=0;i<n;i++){
                //no of elements greater than equal to (i+1)
                buttonPresses[i]=getNoOfElementsGreaterThanEqualTo(p, i+1);
            }
            int []cnt=new int[26];
            for(int i=0;i<n;i++){
                cnt[s.charAt(i)-'a']+=buttonPresses[i]+1;
            }
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<26;i++)
                ans.append(cnt[i]).append(" ");
            System.out.println(ans);
            t--;
        }
    }
    private static int getNoOfElementsGreaterThanEqualTo(int []p, int x){
        int u=0;
        int v=p.length-1;
        int ans=0;
        while(u<=v){
            int mid=(u+v)/2;
            if(p[mid]>=x){
                v=mid-1;
                ans=p.length-mid;
            }else
                u=mid+1;
        }
        return ans;
    }
}
