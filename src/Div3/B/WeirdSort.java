package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WeirdSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0){
            int n,m;
            String []str=br.readLine().split(" ");
            n=Integer.parseInt(str[0]);
            m=Integer.parseInt(str[1]);
            str = br.readLine().split(" ");
            int []a=new int[n];
            int []p=new int[m];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(str[i]);
            }
            str=br.readLine().split(" ");
            for(int i=0;i<m;i++){
                p[i]=Integer.parseInt(str[i]);
            }
            Arrays.sort(p);
            for(int i=0;i<m;i++){
                int j=i;
                while(i+1<m && p[i]+1==p[i+1]){
                    i++;
                }
                Arrays.sort(a,p[j]-1,p[i]+1);
            }
            boolean isSorted=true;
            for(int i=0;i<n-1;i++) {
                if(a[i]>a[i+1]){
                    isSorted=false;
                    break;
                }
            }
            System.out.println(isSorted?"YES":"NO");
            t--;
        }
    }
}
