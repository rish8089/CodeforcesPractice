package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinaryStringReconstruction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            int n = s.length();
            char[] w = new char[n];
            Arrays.fill(w, (char) 0);
            int x = Integer.parseInt(br.readLine());
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '1') {
                    boolean leftFilled = false;
                    boolean rightFilled = false;
                    if (i - x >= 0) {
                        if (w[i - x] != '0') {
                            w[i - x] = '1';
                            leftFilled = true;
                        }
                    }
                    if (i + x < n) {
                        w[i + x] = '1';
                        rightFilled = true;
                    }
                    if (!leftFilled && !rightFilled) {
                        flag = false;
                        break;
                    }
                } else {
                    boolean leftFilled = true;
                    if (i - x >= 0) {
                        if (w[i - x] == '1') {
                            if (i - 3 * x < 0 || w[i - 3 * x] != '1') {
                                leftFilled = false;
                            }
                        }
                        w[i - x] = '0';
                    }
                    if (i + x < n) {
                        w[i + x] = '0';
                    }
                    if (!leftFilled) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                for (int i = 0; i < n; i++) {
                    if (w[i] != '0' && w[i] != '1')
                        System.out.print('0');
                    else
                        System.out.print(w[i]);
                }
                System.out.println();
            } else {
                System.out.println(-1);
            }
            t--;
        }
    }
}
