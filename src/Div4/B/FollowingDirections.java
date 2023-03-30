//package Div4.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FollowingDirections {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            int x=0;
            int y=0;
            boolean flag=false;
            for(int i=0;i<n;i++){
                char c=s.charAt(i);
                switch (c){
                    case 'U':
                        y+=1;
                        break;
                    case 'D':
                        y-=1;
                        break;
                    case 'L':
                        x-=1;
                        break;
                    case 'R':
                        x+=1;
                        break;
                }
                if(x==1 && y==1){
                    flag=true;
                    break;
                }
            }
            System.out.println(flag?"YES":"NO");
            t--;
        }
    }
}
