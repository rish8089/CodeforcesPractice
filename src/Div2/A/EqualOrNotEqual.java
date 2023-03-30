//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EqualOrNotEqual {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            int n = s.length();
            int cntNotEqual = 0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='N')
                    cntNotEqual+=1;
            }
            System.out.println(cntNotEqual==1?"NO":"YES");
//            int[] arr = new int[s.length()];
//            arr[0] = 1;
//            for (int i = 0; i < n - 1; i++) {
//                char c = s.charAt(i);
//                if (i < n - 1) {
//                    if (c == 'E') {
//                        arr[i + 1] = arr[i];
//                    } else {
//                        arr[i + 1] = arr[i] + 1;
//                    }
//                }
//            }
//            System.out.println((arr[0] == arr[n - 1] && s.charAt(n - 1) == 'E') || (arr[0] != arr[n - 1] && s.charAt(n - 1) == 'N') ? "YES" : "NO");
            t--;
        }
    }
}
