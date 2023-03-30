package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExpansionCoefficientOfTheArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(str[i]);
        int i=0;
        int j=n-1;
        int min=Integer.MAX_VALUE;
        int k = -1;
        while(i<=j){
            int minij=Integer.min(a[i],a[j]);
            if(min>minij)
                min=minij;
            int probablek = min/(n-1-i);
            if(k==-1 || k>probablek)
                k=probablek;
            i++;
            j--;
        }
        System.out.println(k);
    }
}
