//package Div3.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PermutationGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int nA=0;
            int nB=0;
            int nAB=0;
            for(int i=0;i<n;i++){
                if(i+1!=a[i])
                    nA++;
                if(n-i!=a[i])
                    nB++;
                if(i+1!=a[i] && n-i!=a[i])
                    nAB++;
            }
            if(nA<=nB-nAB)
                System.out.println("First");
            else if(nB<nA-nAB)
                System.out.println("Second");
            else
                System.out.println("Tie");
            t--;
        }
    }
}
