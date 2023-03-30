//package Div4.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String str=br.readLine();
            long zeros=0,ones=0;
            for(int i=0;i<n;i++){
                char c=str.charAt(i);
                if(c=='0')
                    zeros+=1;
                else
                    ones+=1;
            }
            long maxOnes=0;
            long maxZeros=0;
            for(int i=0;i<n;i++){
                char c=str.charAt(i);
                int j=i;
                while(i+1<n && str.charAt(i+1)==str.charAt(i)){
                        i++;
                }
                if(c=='1') {
                    if (maxOnes < i - j + 1)
                        maxOnes = i - j + 1;
                }else{
                    if (maxZeros < i - j + 1)
                        maxZeros = i - j + 1;
                }
            }
            System.out.println(max((max(zeros*ones, maxOnes*maxOnes)), maxZeros*maxZeros));
            t--;
        }
    }
    private static long max(long a, long b){
        return a>b?a:b;
    }
}
