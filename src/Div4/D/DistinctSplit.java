//package Div4.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistinctSplit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            int []hash=new int[26];
            for(int i=0;i<n;i++)
                hash[s.charAt(i)-'a']++;
            int distinct=0;
            for(int i=0;i<26;i++){
                if(hash[i]>=1)
                    distinct++;
            }
            int []hash1=new int[26];
            int distinct1=0;
            int distinct2=distinct;
            int ans=0;
            for(int i=0;i<n-1;i++){
                char c=s.charAt(i);
                hash1[c-'a']++;
                hash[c-'a']--;
                //increased from 0 to 1
                if(hash1[c-'a']==1)
                    distinct1++;
                if(hash[c-'a']==0)
                    distinct2--;
                if(ans<distinct1+distinct2)
                    ans=distinct1+distinct2;
            }
            System.out.println(ans);
            t--;
        }
    }
//    private int getNoOfDistinctCharacters(int []hash){
//        for(int i=0;i<26;i++){
//            if(hash[i]==1){
//
//            }
//        }
//    }
}
