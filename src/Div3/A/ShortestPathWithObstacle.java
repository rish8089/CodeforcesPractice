package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortestPathWithObstacle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while (t > 0) {
            br.readLine();
            String[] xy = br.readLine().split(" ");
            int ax = Integer.parseInt(xy[0]);
            int ay = Integer.parseInt(xy[1]);
            xy = br.readLine().split(" ");
            int bx = Integer.parseInt(xy[0]);
            int by = Integer.parseInt(xy[1]);
            xy = br.readLine().split(" ");
            int fx = Integer.parseInt(xy[0]);
            int fy = Integer.parseInt(xy[1]);
            if(ax==bx && fx==ax){ //in same row
                if((ay<fy && fy<by) || (by<fy && fy<ay)){ // f in middle of a and b
                    System.out.println(Math.abs(by-ay)+2);
                }else{
                    System.out.println(Math.abs(by-ay));
                }
            } else if(ay==by && fy==by){//in same column
                if((ax<fx && fx<bx) || (bx<fx && fx<ax)) {
                    System.out.println(Math.abs(bx-ax) + 2);
                }else {
                    System.out.println(Math.abs(bx-ax));
                }
            } else{
                System.out.println(Math.abs(bx-ax)+Math.abs(by-ay));
            }
            t--;
        }
    }
}
