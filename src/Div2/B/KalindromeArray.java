//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KalindromeArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            int pos = -1;
            int i = 0;
            while (i < n / 2) {
                if (a[i] != a[n - 1 - i]) {
                    pos = i;
                    break;
                }
                i++;
            }
            if (pos == -1)
                System.out.println("YES");
            else {
                System.out.println(IsPalindromeByIgnoringSomeInstancesOfGivenElement(a, a[i]) || IsPalindromeByIgnoringSomeInstancesOfGivenElement(a, a[n - 1 - i])?"YES":"NO");
            }
            t--;
        }
    }

    private static boolean IsPalindromeByIgnoringSomeInstancesOfGivenElement(int[] a, int num) {
        int n = a.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (a[i] != a[j]) {
                if (a[i] == num || a[j] == num) {
                    while (i < n && a[i] == num)
                        i++;
                    while (j >= 0 && a[j] == num)
                        j--;
                } else
                    return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}
