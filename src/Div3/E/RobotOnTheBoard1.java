package Div3.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RobotOnTheBoard1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        char[] cp = new char[256];
        cp['R'] = 'L';
        cp['L'] = 'R';
        cp['U'] = 'D';
        cp['D'] = 'U';

        while (t > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            String s = br.readLine();

            //horizontal pos estimation

            char fhc = 0;//first horizontal char
            int hpos = 0;
            int ul = s.length()- 1; //upper limit
            boolean flag = true;
            for (int i = 0; i < s.length(); ) {
                char c = s.charAt(i);
                if (c == 'R' || c == 'L') {
                    //setting the first horizontal char
                    if (fhc == 0) {
                        fhc = c;
                    }

                    int cnt = 0;
                    while (i < s.length() && s.charAt(i) != cp[c]) {
                        if (s.charAt(i) == c) {
                            if (cnt + 1 >= m) {
                                ul = i;
                                flag = false;
                                break;
                            }
                            cnt++;
                        }
                        i++;
                    }

                    if (fhc == c) {
                        hpos = Integer.max(hpos, cnt);
                    }
                    if (!flag)
                        break;
                } else
                    i++;
            }

            //vertical pos estimation

            char fvc = 0;//first vertical char
            int vpos = 0;
            flag = true;
            for (int i = 0; i <= ul; ) {
                char c = s.charAt(i);
                if (c == 'U' || c == 'D') {
                    //setting the first vertical char
                    if (fvc == 0) {
                        fvc = c;
                    }

                    int cnt = 0;
                    while (i <= ul && s.charAt(i) != cp[c]) {
                        if (s.charAt(i) == c) {
                            if (cnt + 1 >= n) {
                                flag = false;
                                break;
                            }
                            cnt++;
                        }
                        i++;
                    }

                    if (fvc == c) {
                        vpos = Integer.max(vpos, cnt);
                    }
                    if (!flag)
                        break;
                } else
                    i++;
            }
            System.out.format("%d %d\n", vpos == 'D' ? n - vpos : vpos + 1, fhc == 'R' ? m - hpos : hpos + 1);
            t--;
        }
    }
}
