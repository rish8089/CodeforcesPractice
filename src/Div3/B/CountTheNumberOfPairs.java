//package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountTheNumberOfPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nk=br.readLine().split(" ");
            int n=Integer.parseInt(nk[0]);
            int k=Integer.parseInt(nk[1]);
            String s= br.readLine();
            int []hash=new int[52];
            for(int i=0;i<n;i++){
                char c=s.charAt(i);
                if(c>=65 && c<=90)
                    hash[c-65]++;
                else
                    hash[26+c-97]++;
            }
            int ans=0;
            for(int i=0;i<26;i++){
                ans+=Math.min(hash[i],hash[i+26]);
                int diff=Math.abs(hash[i]-hash[i+26]);
                if(k>0) {
                    int x = Math.min(k, diff / 2);
                    ans+=x;
                    k -= x;
                }
            }
            System.out.println(ans);
            t--;
        }
    }
}
