package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CollectingPackages {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            Location []pl = new Location[n];
            for(int i=0;i<n;i++)
            {
                String []str=br.readLine().split(" ");
                int x=Integer.parseInt(str[0]);
                int y=Integer.parseInt(str[1]);
                pl[i]=new Location(x,y);
            }
            Arrays.sort(pl, (l1, l2) -> {
                if (l1.x < l2.x) {
                    return -1;
                } else if (l1.x == l2.x) {
                    return Integer.compare(l1.y, l2.y);
                }
                return 1;
            });
            boolean flag=true;
            StringBuilder res=new StringBuilder();
            for(int i=0;i<n;i++){
                if(i==0){
                    repeat(res,'R',pl[i].x);
                    repeat(res,'U',pl[i].y);
                }else{
                    if(pl[i].y<pl[i-1].y){
                        //can't go down
                        flag=false;
                        break;
                    }
                    repeat(res,'R',pl[i].x-pl[i-1].x);
                    repeat(res,'U',pl[i].y-pl[i-1].y);
                }
            }
            if(flag){
                System.out.println("YES");
                System.out.println(res);
            }else{
                System.out.println("NO");
            }
            t--;
        }
    }
    private static class Location{
        int x;
        int y;
        Location(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    private static void repeat(StringBuilder res, char c, int n) {
        for(int i = 0; i< n; i++) {
            res.append(c);
        }
    }
}
