package Div3.B;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayStabilization {
    private static final int LIM=100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        sortUsingHash(a,n);
        if(n==2)
            System.out.println(0);
        else {
            System.out.println(Math.min(a[n - 1] - a[0], Math.min(a[n-1]-a[1], a[n-2]-a[0])));
        }
    }

    private static void sortUsingHash(int []a, int n){
        int []hash=new int[LIM+1];
        for(int i=0;i<n;i++)
            hash[a[i]]++;
        int k=0;
        for(int i=0;i<=LIM;i++){
            for(int j=1;j<=hash[i];j++)
                a[k++]=i;
        }
    }

}
