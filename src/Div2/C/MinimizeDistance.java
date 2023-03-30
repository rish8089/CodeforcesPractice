//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimizeDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String[] str = br.readLine().split(" ");

            List<Integer> leftDepotsPositions = new ArrayList<>();
            List<Integer> rightDepotsPositions = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                if (val < 0)
                    leftDepotsPositions.add(-val);
                else if (val > 0)
                    rightDepotsPositions.add(val);
            }
            Collections.sort(leftDepotsPositions);
            Collections.sort(rightDepotsPositions);

            //minimum total distance covered in left assuming we exit from right at end
            long totalMinLeftDistance = 0;
            for (int i = leftDepotsPositions.size() - 1; i >= 0; i -= k) {
                totalMinLeftDistance += 2 * leftDepotsPositions.get(i);
            }
            //minimum total distance covered in right assuming we exit from left at end
            long totalMinRightDistance = 0;
            for (int i = rightDepotsPositions.size() - 1; i >= 0; i -= k) {
                totalMinRightDistance += 2 * rightDepotsPositions.get(i);
            }
            if (leftDepotsPositions.size() > 0 && rightDepotsPositions.size() > 0) {
                System.out.println(Long.min(totalMinLeftDistance + totalMinRightDistance - leftDepotsPositions.get(leftDepotsPositions.size() - 1), totalMinLeftDistance + totalMinRightDistance - rightDepotsPositions.get(rightDepotsPositions.size() - 1)));
            } else if (leftDepotsPositions.size() > 0) {
                System.out.println(totalMinLeftDistance - leftDepotsPositions.get(leftDepotsPositions.size() - 1));
            } else if (rightDepotsPositions.size() > 0) {
                System.out.println(totalMinRightDistance - rightDepotsPositions.get(rightDepotsPositions.size() - 1));
            } else {
                System.out.println(0);
            }
            t--;
        }
    }

    private static long abs(long x) {
        return x < 0 ? -x : x;
    }
}
