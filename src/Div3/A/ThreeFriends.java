//codeforces round 605
package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThreeFriends {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases

        while (t > 0) {
            String[] str = br.readLine().split(" ");
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++)
                arr[i] = Integer.parseInt(str[i]);
            Arrays.sort(arr);
            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                System.out.println(0);
            } else if (arr[0] == arr[1]) {
                if (arr[2] - arr[1] == 1) {
                    System.out.println(0);
                } else {
                    System.out.println(2 * (arr[2] - arr[1] - 2));
                }
            } else if (arr[1] == arr[2]) {
                if (arr[1] - arr[0] == 1) {
                    System.out.println(0);
                } else {
                    System.out.println(2 * (arr[1] - arr[0] - 2));
                }
            } else {
                System.out.println(2 * (arr[2] - arr[0] - 2));
            }
            t--;
        }
    }
}
