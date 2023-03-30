//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IncreasingSubsequenceHard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(str[i]);
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int j = n - 1;
        int prev = 0;
        while (i <= j) {
            if (prev < a[i] && prev < a[j]) {
                if (a[i] < a[j]) {
                    prev = a[i];
                    i++;
                    ans.append('L');
                } else if (a[i] > a[j]) {
                    prev = a[j];
                    j--;
                    ans.append('R');
                } else {
                    //trying to find an unequal pair
                    int cnt = 1;
                    while (i + 1 < j && j - 1 > i && a[i + 1] == a[j - 1] && a[i + 1] > a[i]) {
                        cnt++;
                        i++;
                        j--;
                    }
                    //we got unequal pair
                    if (i + 1 < j - 1 && a[i + 1] != a[j - 1]) {
                        if (a[i] < a[i + 1] && a[i] < a[j - 1]) {
                            //choose the minimal
                            if (a[i + 1] < a[j - 1]) {
                                repeat(ans, 'L', cnt);
                                prev = a[i];
                                i += 1;
                                j += cnt - 1;
                            } else {
                                repeat(ans, 'R', cnt);
                                prev = a[i];
                                j -= 1;
                                i -= cnt - 1;
                            }
                        } else if (a[i] < a[i + 1]) {
                            repeat(ans, 'L', cnt);
                            prev = a[i];
                            i += 1;
                            j += cnt - 1;

                        } else if (a[i] < a[j - 1]) {
                            repeat(ans, 'R', cnt);
                            prev = a[i];
                            j -= 1;
                            i -= cnt - 1;
                        } else {
                            repeat(ans, 'L', cnt);
                            break;
                        }
                    } else {
                        repeat(ans, 'L', cnt);
                        break;
                    }
                }
            } else if (prev < a[i]) {
                prev = a[i];
                i++;
                ans.append('L');
            } else if (prev < a[j]) {
                prev = a[j];
                j--;
                ans.append('R');
            } else
                break;
        }
        System.out.println(ans.length());
        System.out.println(ans);
    }

    private static void repeat(StringBuilder ans, char c, int cnt) {
        for (int i = 1; i <= cnt; i++)
            ans.append(c);
    }
}
