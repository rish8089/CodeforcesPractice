package Div2.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YetAnotherProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(str[i]);
        int[] rightDuplicateEndIdx = new int[n];
        for (int i = 0; i < n; i++) {
            int j = i;
            while (i + 1 < n && a[i] == a[i + 1])
                i++;
            for (int k = j; k <= i; k++)
                rightDuplicateEndIdx[k] = i;
        }
        int[] leftDuplicateEndIdx = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int j = i;
            while (i - 1 >= 0 && a[i] == a[i - 1])
                i--;
            for (int k = j; k >= i; k--)
                leftDuplicateEndIdx[k] = i;
        }
        int []prefixXor=new int[n];
        for(int i=0;i<n;i++){
            if(i==0)
                prefixXor[i]=a[i];
            else
                prefixXor[i]=a[i]^prefixXor[i-1];
        }
        while (q > 0) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]);
            int r = Integer.parseInt(lr[1]);
            l--;
            r--;
            int len = r - l + 1;
            if (len % 2 != 0) {
                if (rightDuplicateEndIdx[l] >= r) {
                    System.out.println(a[l] == 0 ? 0 : 1);
                } else {
                    if (len == 1) {
                        System.out.println(-1);
                    } else {
                        System.out.println(rangeXor(l,r,prefixXor)==0?1:2);
                    }
                }
            } else {
                if (rightDuplicateEndIdx[l] >= r) {
                    if (a[l] == 0) {
                        System.out.println(0);
                    } else {
                        System.out.println(len == 2 ? -1 : len != 4 ? 2 : 3);
                    }
                } else {
                    if (len == 2) {
                        System.out.println(-1);
                    }
                    else {

                    }
                }
            }
            q--;
        }

    }
    private static int rangeXor(int l, int r, int[]prefixXor){
        if(l==0)
            return prefixXor[r];
        else
            return prefixXor[r]^prefixXor[l-1];
    }
}
