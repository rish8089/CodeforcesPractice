//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(str[i]);
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int j = n - 1;
        int prev = 0;
        while (i <= j) {
            if(prev<a[i] && prev<a[j]){
                if(a[i]<a[j]){
                    prev=a[i];
                    i++;
                    ans.append('L');
                }else{
                    prev=a[j];
                    j--;
                    ans.append('R');
                }
            }else if(prev<a[i]){
                prev=a[i];
                i++;
                ans.append('L');
            }else if(prev<a[j]){
                prev=a[j];
                j--;
                ans.append('R');
            }else
                break;
        }
        System.out.println(ans.length());
        System.out.println(ans);
    }
}
