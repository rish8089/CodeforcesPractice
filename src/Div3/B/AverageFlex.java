package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AverageFlex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            Arrays.sort(a);
            int cnt=0;
            int noOfElementsGreaterForLastIdx = 0;
            for(int i=n-1;i>=0;i--){
                if(i+1<n) {
                    if (a[i] < a[i + 1])
                        noOfElementsGreaterForLastIdx = n-1-i;
                }
                if(n-noOfElementsGreaterForLastIdx>noOfElementsGreaterForLastIdx)
                    cnt+=1;
            }
            System.out.println(cnt);
            t--;
        }

    }
}
