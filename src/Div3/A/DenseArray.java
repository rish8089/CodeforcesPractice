package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DenseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            int ans = 0;
            for (int i = 0; i < n - 1; i++) {
                int max = Math.max(a[i], a[i + 1]);
                int min = Math.min(a[i], a[i + 1]);
                while(min*2<max){
                    min=min*2;
                    ans+=1;
                }
            }
            System.out.println(ans);
            t--;
        }
    }
}
