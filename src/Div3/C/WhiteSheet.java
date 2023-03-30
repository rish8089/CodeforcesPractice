//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhiteSheet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Rectangle []r=new Rectangle[3];
        for(int i=0;i<3;i++){
            String []str=br.readLine().split(" ");
            int x1=Integer.parseInt(str[0]);
            int y1=Integer.parseInt(str[1]);
            int x2=Integer.parseInt(str[2]);
            int y2=Integer.parseInt(str[3]);
            Node bottomLeft = new Node(x1,y1);
            Node topRight = new Node(x2,y2);
            r[i]=new Rectangle(bottomLeft,topRight);
        }

        if (r[1].bottomLeft.y <= r[0].bottomLeft.y && r[0].topRight.y <= r[1].topRight.y && r[1].bottomLeft.x <= r[0].bottomLeft.x && r[0].topRight.x <= r[1].topRight.x) {
            System.out.println("NO");
        } else if (r[2].bottomLeft.y <= r[0].bottomLeft.y && r[0].topRight.y <= r[2].topRight.y && r[2].bottomLeft.x <= r[0].bottomLeft.x && r[0].topRight.x <= r[2].topRight.x) {
            System.out.println("NO");
        } else if (r[1].bottomLeft.y <= r[0].bottomLeft.y && r[0].topRight.y <= r[1].topRight.y && r[2].bottomLeft.y <= r[0].bottomLeft.y && r[0].topRight.y <= r[2].topRight.y) {
            if (r[1].bottomLeft.x <= r[0].bottomLeft.x && r[0].topRight.x <= r[2].topRight.x && r[2].bottomLeft.x <= r[1].topRight.x) {
                System.out.println("NO");
            } else if (r[2].bottomLeft.x <= r[0].bottomLeft.x && r[0].topRight.x <= r[1].topRight.x && r[1].bottomLeft.x <= r[2].topRight.x) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        } else if (r[1].bottomLeft.x <= r[0].bottomLeft.x && r[0].topRight.x <= r[1].topRight.x && r[2].bottomLeft.x <= r[0].bottomLeft.x && r[0].topRight.x <= r[2].topRight.x) {
            if (r[1].bottomLeft.y <= r[0].bottomLeft.y && r[0].topRight.y <= r[2].topRight.y && r[2].bottomLeft.y <= r[1].topRight.y) {
                System.out.println("NO");
            } else if (r[2].bottomLeft.y <= r[0].bottomLeft.y && r[0].topRight.y <= r[1].topRight.y && r[1].bottomLeft.y <= r[2].topRight.y) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        } else {
            System.out.println("YES");
        }

    }

    private static class Rectangle{
        Node bottomLeft;
        Node topRight;
        Rectangle(Node bottomLeft, Node topRight){
            this.bottomLeft=bottomLeft;
            this.topRight=topRight;
        }
    }
    private static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
