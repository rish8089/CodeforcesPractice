package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SimilarPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int e=0,o=0;
            for(int i=0;i<n;i++){
                if(a[i]%2==0)
                    e+=1;
                else
                    o+=1;
            }
            if(e%2!=0 && o%2!=0){
                Arrays.sort(a);
                boolean pairExistsWithDiffOne = false;
                for(int i=0;i<n-1;i++){
                    if(a[i+1]-a[i]==1){
                        pairExistsWithDiffOne=true;
                        break;
                    }
                }
                System.out.println(pairExistsWithDiffOne?"YES":"NO");
            }else{
                System.out.println("YES");
            }
            t--;
        }
    }
}
