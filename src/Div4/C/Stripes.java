//package Div4.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stripes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
              br.readLine();
//            br.readLine();
            String []str=new String[8];
            for(int i=0;i<8;i++)
                str[i]=br.readLine();
            boolean foundLatestPaint = false;
            //traversing all rows
            for(int i=0;i<8;i++){
                boolean flag=true;
                for(int j=0;j<8;j++){
                    char c=str[i].charAt(j);
                    if(c!='R'){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    System.out.println('R');
                    foundLatestPaint=true;
                    break;
                }
            }
            if(foundLatestPaint) {
                t--;
                continue;
            }
            //traversing all columns
            for(int i=0;i<8;i++){
                boolean flag=true;
                for(int j=0;j<8;j++){
                    char c=str[j].charAt(i);
                    if(c!='B'){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    System.out.println('B');
                    break;
                }
            }
            t--;
        }
    }
}
