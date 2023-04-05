//package Div4.F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BouncyBall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nmi1i2j1j2d = br.readLine().split(" ");
            int n=Integer.parseInt(nmi1i2j1j2d[0]);
            int m=Integer.parseInt(nmi1i2j1j2d[1]);
            int i1=Integer.parseInt(nmi1i2j1j2d[2]);
            int j1=Integer.parseInt(nmi1i2j1j2d[3]);
            int i2=Integer.parseInt(nmi1i2j1j2d[4]);
            int j2=Integer.parseInt(nmi1i2j1j2d[5]);
            String d=nmi1i2j1j2d[6];
            boolean [][][]visited=new boolean[n][m][4];
            Direction dir=getDirection(d);
            System.out.println(dfs(i1-1,j1-1,i2-1,j2-1,dir,visited,n,m));
            t--;
        }
    }
    private static int dfs(int si, int sj, int di, int dj, Direction dir, boolean [][][]visited, int n, int m) {
        int dx=dir.dx;
        int dy=dir.dy;
        int dirInt = getDirectionInInt(dir);
        while(true){
            if(visited[si][sj][dirInt])
                return -1;
            visited[si][sj][dirInt]=true;
            if(si==di && sj==dj)
                return 0;
            boolean reachedBoundary=false;
            //hit the bottom or up, reverse dy
            if(si + dy == n || si + dy == -1){
                dy=-dy;
                reachedBoundary=true;
            }
            //hit the left or right, reverse dx
            if(sj + dx == m || sj + dx == -1){
                dx=-dx;
                reachedBoundary=true;
            }
            if(reachedBoundary)
                break;
            si+=dy;
            sj+=dx;
        }
        int ret = dfs(si,sj,di,dj,new Direction(dx,dy),visited,n,m);
        if(ret==-1)
            return -1;
        return 1+ret;
    }
    private static Direction getDirection(String d){
        switch (d) {
            case "DL": return new Direction(-1,1);
            case "UL": return new Direction(-1,-1);
            case "UR": return new Direction(1,-1);
            default: return new Direction(1,1);
        }
    }

    private static int getDirectionInInt(Direction dir) {
        int dx=dir.dx;
        int dy=dir.dy;
        if (dx == -1) {
            return dy == 1 ? 0 : 1;
        } else {
            return dy == 1 ? 3 : 2;
        }
    }

    static class Direction{
        int dx;
        int dy;
        Direction(int dx, int dy){
            this.dx=dx;
            this.dy=dy;
        }
    }
}
