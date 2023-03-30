package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RobotBreakout {
    private static int LIM = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        while (q > 0) {
            int n = Integer.parseInt(br.readLine());
            Robot[] r = new Robot[n];
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                int ix = Integer.parseInt(str[0]);
                int iy = Integer.parseInt(str[1]);
                int ac1 = Integer.parseInt(str[2]);
                int ac2 = Integer.parseInt(str[3]);
                int ac3 = Integer.parseInt(str[4]);
                int ac4 = Integer.parseInt(str[5]);
                boolean[] actions = {ac1 == 1, ac2 == 1, ac3 == 1, ac4 == 1};
                r[i] = new Robot(new Node(ix, iy), actions);
            }
            //check if there are robots which can't move
            int cnt = 0;
            Node dest = null;
            Set<Node> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!r[i].actions[0] && !r[i].actions[1] && !r[i].actions[2] && !r[i].actions[3]) {
                    if (!set.contains(r[i].node)) {
                        cnt += 1;
                        dest = new Node(r[i].node.x, r[i].node.y);
                        set.add(dest);
                    }
                }
            }
            if (cnt > 0) {
                if (cnt > 1) {
                    System.out.println(0);
                } else {
                    if (!canAllRobotsReachToGivenDest(r, dest)) {
                        System.out.println(0);
                    } else {
                        System.out.format("%d %d %d\n", 1, dest.x, dest.y);
                    }
                }
            } else {
                Range hr = getHorizontalRangeWhereAllRobotsCanReach(r);
                Range vr = getVerticalRangeWhereAllRobotsCanReach(r);
                if(hr==null || vr==null){
                    System.out.println(0);
                }else{
                    System.out.format("%d %d %d\n", 1, hr.v1, vr.v1);
                }
            }
            q--;
        }
    }

    private static boolean canAllRobotsReachToGivenDest(Robot[] r, Node dest) {
        for (Robot robot : r) {
            int diffx = dest.x - robot.node.x;
            int diffy = dest.y - robot.node.y;
            if (diffx != 0) {
                if (diffx < 0 && !robot.actions[0]) {
                    return false;
                }
                if (diffx > 0 && !robot.actions[2]) {
                    return false;
                }
            }
            if (diffy != 0) {
                if (diffy < 0 && !robot.actions[3]) {
                    return false;
                }
                if (diffy > 0 && !robot.actions[1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Range getVerticalRangeWhereAllRobotsCanReach(Robot[] r) {
        int y1, y2;
        y1 = -LIM;
        y2 = LIM;
        for (Robot robot : r) {
            if (!robot.actions[1] && !robot.actions[3]) {
                if (y1 <= robot.node.y && robot.node.y <= y2) {
                    y1 = robot.node.y;
                    y2 = robot.node.y;
                } else {
                    return null;
                }
            } else {
                if (robot.actions[1] && !robot.actions[3]) {
                    if (robot.node.y <= y2) {
                        y1 = Integer.max(y1, robot.node.y);
                    } else
                        return null;
                } else if (robot.actions[3] && !robot.actions[1]) {
                    if (robot.node.y >= y1) {
                        y2 = Integer.min(y2, robot.node.y);
                    } else {
                        return null;
                    }
                }
            }
        }
        if (y1 <= y2)
            return new Range(y1, y2);
        else
            return null;
    }

    private static Range getHorizontalRangeWhereAllRobotsCanReach(Robot[] r) {
        int x1, x2;
        x1 = -LIM;
        x2 = LIM;
        for (Robot robot : r) {
            if (!robot.actions[0] && !robot.actions[2]) {
                if (x1 <= robot.node.x && robot.node.x <= x2) {
                    x1 = robot.node.x;
                    x2 = robot.node.x;
                } else {
                    return null;
                }
            } else {
                if (robot.actions[0] && !robot.actions[2]) {
                    if (robot.node.x >= x1) {
                        x2 = Integer.min(x2, robot.node.x);
                    } else
                        return null;
                } else if (robot.actions[2] && !robot.actions[0]) {
                    if (robot.node.x <= x2) {
                        x1 = Integer.max(x1, robot.node.x);
                    } else {
                        return null;
                    }
                }
            }
        }
        if(x1<=x2)
        return new Range(x1, x2);
        else
            return null;
    }

    private static class Robot {
        Node node;
        boolean[] actions;

        Robot(Node node, boolean[] actions) {
            this.node = node;
            this.actions = actions;
        }
    }

    private static class Range{
        int v1;
        int v2;
        Range(int v1, int v2){
            this.v1=v1;
            this.v2=v2;
        }
    }

    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Node() {
            x = Integer.MIN_VALUE;
            y = Integer.MIN_VALUE;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
