package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ReachableNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Boolean> mp = new HashMap<>();
        int cnt = 0;
        while (!mp.containsKey(n)) {
            mp.put(n, true);
            cnt += 1;
            n = n + 1;
            n = removeTrailingZeros(n);
        }
        System.out.println(cnt);
    }

    private static int removeTrailingZeros(int n) {
        while (n % 10 == 0) {
            n /= 10;
        }
        return n;
    }
}
