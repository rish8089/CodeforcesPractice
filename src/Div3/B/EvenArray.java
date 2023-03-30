package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String[] str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int e=0;
            for(int i=0;i<n;i++){
                if(a[i]%2==0)
                    e=e+1;
            }
            if((n+1)/2!=e){
                System.out.println(-1);
            } else {
                int m = 0;//moves
                for (int i = 0; i < n; i += 2) {
                    if (a[i] % 2 != 0) {
                        m = m + 1;
                    }
                }
                System.out.println(m);
            }
            t--;
        }
    }
}
