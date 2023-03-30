//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nkx = br.readLine().split(" ");
            int n = Integer.parseInt(nkx[0]);
            int k = Integer.parseInt(nkx[1]);
            long x = Long.parseLong(nkx[2]);
            String s = br.readLine();

            if (x == 1) {
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) != '*')
                        ans.append(s.charAt(i));
                }
                System.out.println(ans);
            } else {
                //there should be some asterisks
                long abStrings = 1;
                int nextIterationStartPos = -1;
                for (int i = n - 1; i >= 0; i--) {
                    if (s.charAt(i) == '*') {
                        int cnt = 1;
                        while (i - 1 >= 0 && s.charAt(i - 1) == '*') {
                            cnt += 1;
                            i--;
                        }
//                        if (abStrings == 0)
//                            abStrings = cnt * k + 1;
//                        else {
//                            long temp = abStrings * (cnt * k + 1);
//                            assert(temp>=abStrings);
//                            abStrings = temp;
//                        }
                        long temp = abStrings * (cnt * k + 1);
                        if (temp < 0 || temp < abStrings) {
                            nextIterationStartPos = i;
                            break;
                        } else if (x <= temp) {
                            nextIterationStartPos = i;
                            break;
                        }
                        abStrings = temp;
                    }
                }
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < nextIterationStartPos; i++) {
                    if (s.charAt(i) != '*')
                        ans.append(s.charAt(i));
                }
                while (nextIterationStartPos + 1 < n && s.charAt(nextIterationStartPos + 1) == '*') {
                    nextIterationStartPos += 1;
                }
                nextIterationStartPos++;
                long q = x / abStrings;
                long rem = x % abStrings;
                if (rem > 0) {
                    q = q + 1;
                    x = rem;
                } else {
                    x = abStrings;
                }
                while (q > 1) {
                    ans.append('b');
                    q--;
                }

                for (int i = nextIterationStartPos; i < n; i++) {
                    if (s.charAt(i) == '*') {
                        int cnt = 1;
                        while (i + 1 < n && s.charAt(i + 1) == '*') {
                            cnt += 1;
                            i++;
                        }
                        abStrings = abStrings / (cnt * k + 1);
                        q = x / abStrings;
                        rem = x % abStrings;
                        if (rem > 0) {
                            q = q + 1;
                            x = rem;
                        } else {
                            x = abStrings;
                        }
                        while (q > 1) {
                            ans.append('b');
                            q--;
                        }
                    } else
                        ans.append(s.charAt(i));
                }

                System.out.println(ans);
            }

            t--;
        }
    }
}
