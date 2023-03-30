package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoubleEndedStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int ans=-1;
            String a=br.readLine();
            String b=br.readLine();
            for(int i=0;i<a.length();i++){
                for(int j=i;j<a.length();j++){
                    String s=a.substring(i,j+1);
                    int pos=b.indexOf(s);
                    if(pos!=-1){
                        int operations1 = a.length()-s.length();
                        int operations2 = b.length()-s.length();
                        if(ans==-1 || ans>operations1+operations2){
                            ans=operations1+operations2;
                        }
                    }
                }
            }

            System.out.println(ans==-1?a.length()+b.length():ans);
            t--;
        }
    }
}
