package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BerryJam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[2*n];
            for(int i=0;i<2*n;i++)
                a[i]=Integer.parseInt(str[i]);
            int b=0,s=0;
            for(int i=0;i<2*n;i++){
                if(a[i]==1)
                    s+=1;
                else
                    b+=1;
            }
            if(s==b)
                System.out.println(0);
            else {
                int i = n - 1;
                int j = n;
                if(s>b){
                    while(i>=0 && j<2*n && s>b){
                        if(a[i]==2 || a[j]==2) {
                            if (a[i] == 1)
                                i--;
                            else
                                j++;
                            b += 1;
                        }
                    }
                }
            }
            t--;
        }
    }
}
