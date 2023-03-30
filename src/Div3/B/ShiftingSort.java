package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ShiftingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
                b[i] = a[i];
            }
            Arrays.sort(b);
            Sol[] arr = new Sol[n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (b[i] == a[j]) {
                        if (i < j) {
                            shiftArray(a, i, j, 1);
                            arr[cnt] = new Sol(i + 1, j + 1, j-i);
                            cnt++;
                        }
                        break;
                    }
                }
            }
            System.out.println(cnt);
            for (int i = 0; i < cnt; i++) {
                System.out.format("%d %d %d\n", arr[i].si, arr[i].ei, arr[i].d);
            }
            t--;
        }
    }

    private static void shiftArray(int[] a, int i, int j, int d) {
        reverseArray(a, i, j - d);
        reverseArray(a, j - d + 1, j);
        reverseArray(a, i, j);
    }

    private static void reverseArray(int[] a, int i, int j) {
        while (i < j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }
    }

    private static class Sol {
        int si;
        int ei;
        int d;

        Sol(int si, int ei, int d) {
            this.si = si;
            this.ei = ei;
            this.d = d;
        }
    }
}
