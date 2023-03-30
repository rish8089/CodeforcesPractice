//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchingLocalMinimum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int u = 1;
        int v = n;
        int pos = -1;
        while (u <= v) {
            int mid = (u + v) / 2;
            if(a[mid]==0) {
                System.out.format("? %d\n", mid);
                a[mid] = Integer.parseInt(br.readLine());
            }
            if (mid - 1 >= 1 && mid + 1 <= n) {
                if (a[mid - 1] == 0) {
                    System.out.format("? %d\n", mid - 1);
                    a[mid - 1] = Integer.parseInt(br.readLine());
                }
                if (a[mid + 1] == 0) {
                    System.out.format("? %d\n", mid + 1);
                    a[mid + 1] = Integer.parseInt(br.readLine());
                }
                int min = Integer.min(a[mid - 1], a[mid + 1]);
                if (a[mid] < min) {
                    pos = mid;
                    break;
                } else if (a[mid - 1] < a[mid]) {
                    v = mid - 1;
                } else {
                    u = mid + 1;
                }
            } else if (mid - 1 >= 1) {
                if (a[mid - 1] == 0) {
                    System.out.format("? %d\n", mid - 1);
                    a[mid - 1] = Integer.parseInt(br.readLine());
                }
                if (a[mid] < a[mid - 1]) {
                    pos = mid;
                    break;
                } else
                    v = mid - 1;
            } else if (mid + 1 <= n) {
                if (a[mid + 1] == 0) {
                    System.out.format("? %d\n", mid + 1);
                    a[mid + 1] = Integer.parseInt(br.readLine());
                }
                if (a[mid] < a[mid + 1]) {
                    pos = mid;
                    break;
                } else
                    u = mid + 1;
            } else {
                pos = mid;
                break;
            }
        }
        System.out.format("! %d\n", pos);
    }
}
