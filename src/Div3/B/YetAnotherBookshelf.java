package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YetAnotherBookshelf {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            int j=0;
            while(j<n && a[j]==0){
                j++;
            }
            int k=n-1;
            while(k>=0 && a[k]==0){
                k--;
            }
            int sum=0;
            for(int i=j;i<=k;i++){
                int l=i;
                if(a[i]==0){
                    while(i+1<=k && a[i+1]==0){
                        i++;
                    }
                    sum+=i-l+1;
                }
            }
            System.out.println(sum);
            t--;
        }
    }
}
