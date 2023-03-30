package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Heaters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nr = br.readLine().split(" ");
        int n = Integer.parseInt(nr[0]);
        int r = Integer.parseInt(nr[1]);
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(str[i]);
        int[] status = new int[n];
        int ans = recurse(status, a, 0, n - 1, r);
        if (isWholeRegionWarm(status, 0, n - 1)) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }

    private static int recurse(int[] status, int[] a, int i, int j, int range) {
        if (i > j)
            return 0;
        int mid = (i + j) / 2;
        int k = 0;
        while (mid - k >= i || mid + k <= j) {
            if ((mid - k >= i && a[mid - k] == 1) || (mid + k <= j && a[mid + k] == 1)) {
                break;
            } else {
                k++;
            }
        }
        int l, r;
        if (mid - k >= i && a[mid - k] == 1) {
            l = Math.max(mid - k - range + 1, i);
            r = Math.min(mid - k + range - 1, j);
        } else if (mid + k <= j && a[mid + k] == 1) {
            l = Math.max(mid + k - range + 1, i);
            r = Math.min(mid + k + range - 1, j);
        } else {
            return 0;
        }
        int lans = recurse(status, a, i, l - 1, range);
        int rans = recurse(status, a, r + 1, j, range);
        int cnt = 0;
        int lpos = getLeftmostSetPosition(a, l, r);
        if (lpos != -1) {
            int lposlrange = Math.max(lpos - range + 1, 0);
            int lposrrange = Math.min(lpos + range - 1, status.length - 1);
            if (!isWholeRegionWarm(status, lposlrange, l-1)) {
                Arrays.fill(status, lposlrange, lpos + 1, 1);
                Arrays.fill(status, lpos, lposrrange + 1, 1);
                cnt++;
            }
        }
        int rpos = getRightmostSetPosition(a, l, r);
        if (rpos != -1) {
            int rposlrange = Math.max(rpos - range + 1, 0);
            int rposrrange = Math.min(rpos + range - 1, status.length - 1);
            if (!isWholeRegionWarm(status, r+1, rposrrange)) {
                Arrays.fill(status, rposlrange, rpos + 1, 1);
                Arrays.fill(status, rpos, rposrrange + 1, 1);
                cnt++;
            }
        }
        if(!isWholeRegionWarm(status, l, r)){
            Arrays.fill(status, l, r + 1, 1);
            cnt++;
        }
        return lans + rans + cnt;
    }

    private static boolean isWholeRegionWarm(int[] status, int i, int j) {
        for (int m = i; m <= j; m++) {
            if (status[m] == 0)
                return false;
        }
        return true;
    }

    private static int getLeftmostSetPosition(int[] a, int i, int j) {
        while (i <= j) {
            if (a[i] == 1)
                return i;
            i++;
        }
        return -1;
    }

    private static int getRightmostSetPosition(int[] a, int i, int j) {
        while (j >= i) {
            if (a[j] == 1)
                return j;
            j--;
        }
        return -1;
    }
}
