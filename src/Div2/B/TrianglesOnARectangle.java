package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TrianglesOnARectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] wh = br.readLine().split(" ");
            int w = Integer.parseInt(wh[0]);
            int h = Integer.parseInt(wh[1]);
            List<Integer> bottomHorizontalPoints = new ArrayList<>();
            List<Integer> topHorizontalPoints = new ArrayList<>();
            List<Integer> leftVerticalPoints = new ArrayList<>();
            List<Integer> rightVerticalPoints = new ArrayList<>();
            String[] str = br.readLine().split(" ");
            int k = Integer.parseInt(str[0]);
            for (int i = 0; i < k; i++)
                bottomHorizontalPoints.add(Integer.parseInt(str[i + 1]));
            str = br.readLine().split(" ");
            k = Integer.parseInt(str[0]);
            for (int i = 0; i < k; i++)
                topHorizontalPoints.add(Integer.parseInt(str[i + 1]));
            str = br.readLine().split(" ");
            k = Integer.parseInt(str[0]);
            for (int i = 0; i < k; i++)
                leftVerticalPoints.add(Integer.parseInt(str[i + 1]));
            str = br.readLine().split(" ");
            k = Integer.parseInt(str[0]);
            for (int i = 0; i < k; i++)
                rightVerticalPoints.add(Integer.parseInt(str[i + 1]));
            int bottomHorizontalMaxDiff = maxDiff(bottomHorizontalPoints);
            int topHorizontalMaxDiff = maxDiff(topHorizontalPoints);
            int leftVerticalMaxDiff = maxDiff(leftVerticalPoints);
            int rightVerticalMaxDiff = maxDiff(rightVerticalPoints);
            System.out.println(Long.max((long)Integer.max(bottomHorizontalMaxDiff, topHorizontalMaxDiff) * h, (long)Integer.max(leftVerticalMaxDiff, rightVerticalMaxDiff) * w));
            t--;
        }
    }

    private static int maxDiff(List<Integer> list) {
        int max = 0;
        for (Integer elem : list) {
            max = Integer.max(max, elem);
        }
        int min = -1;
        for (Integer elem : list) {
            if (min == -1)
                min = elem;
            else
                min = Integer.min(min, elem);
        }
        return max - min;
    }
}
