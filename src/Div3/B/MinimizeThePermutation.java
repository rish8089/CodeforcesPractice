package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimizeThePermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            int[] pos = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
                pos[a[i] - 1] = i;
            }
            int leftPos = 0;
            for (int i = 0; i < n; i++) {
                if (pos[i] < leftPos) {
                    continue;
                }
                int posi = pos[i];
                for (int j = posi; j > leftPos; j--) {
                    swap(pos, a[j - 1] - 1, a[j] - 1);
                    swap(a, j - 1, j);
                }
                if (posi == leftPos) {
                    leftPos = posi + 1;
                } else {
                    leftPos = posi;
                }

            }
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            t--;
        }
    }

    private static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
