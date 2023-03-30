package Div3.A;//package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircleOfStudents2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        while (q > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            if (n == 1)
                System.out.println("YES");
            else {
                System.out.println(InClockwiseDirection(a) || InAntiClockwiseDirection(a) ? "YES" : "NO");
            }
            q--;
        }
    }
    private static boolean InClockwiseDirection(int []a){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            int nxt=(a[i]+1)%n;
            if(nxt==0) nxt=n;
            if(nxt!=a[i+1]) return false;
        }
        return true;
    }
    private static boolean InAntiClockwiseDirection(int []a){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            int nxt=(a[i]-1)%n;
            if(nxt==0) nxt=n;
            if(nxt!=a[i+1]) return false;
        }
        return true;
    }
}
