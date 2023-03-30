package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManyEqualSubstrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nk=br.readLine().split(" ");
        int n=Integer.parseInt(nk[0]);
        int k=Integer.parseInt(nk[1]);
        String t=br.readLine();
        StringBuilder ans=new StringBuilder(t);
        int i=0;
        while(k>0){
            if(i==ans.length()){
                ans.append(t);
                k--;
            }else {
                String s=ans.substring(i);
                String st=t.substring(0,s.length());
                if(s.equals(st)){
                    if(st.length()<t.length()) {
                        ans.append(t, st.length(), t.length());
                    }
                    k--;
                }
            }
            i++;
        }
        System.out.println(ans);
    }
}