//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingBigram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            String []bigrams=new String[n-2];
            for(int i=0;i<n-2;i++)
                bigrams[i]=str[i];
            StringBuilder ans=new StringBuilder();
            ans.append(bigrams[0]);
            for(int i=1;i<n-2;i++){
                if(bigrams[i-1].charAt(1)!=bigrams[i].charAt(0)){
                    ans.append(bigrams[i]);
                }else{
                    ans.append(bigrams[i].charAt(1));
                }
            }
            if(ans.length()<n){
                ans.append('a');
            }
            System.out.println(ans);
            t--;
        }
    }
}
