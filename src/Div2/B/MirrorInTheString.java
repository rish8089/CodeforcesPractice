//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MirrorInTheString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String str=br.readLine();
//            boolean allIdentical = true;
//            int i=0;
//            while(i+1<str.length() && str.charAt(i+1)<=str.charAt(i)) {
//                if(str.charAt(i+1)!=str.charAt(i))
//                    allIdentical = false;
//                i++;
//            }
//            if(allIdentical)
//                System.out.format("%c%c\n",str.charAt(i),str.charAt(i));
//            else {
//                StringBuilder ans = new StringBuilder();
//                ans.append(str.substring(0, i + 1));
//                for (int j = i; j >= 0; j--)
//                    ans.append(str.charAt(j));
//                System.out.println(ans);
//            }
            if(n==1 || str.charAt(0)==str.charAt(1))
                System.out.format("%c%c\n",str.charAt(0),str.charAt(0));
            else{
                int i=0;
                while(i+1<str.length() && str.charAt(i+1)<=str.charAt(i)) {
                    i++;
                }
                StringBuilder ans = new StringBuilder();
                ans.append(str.substring(0, i + 1));
                for (int j = i; j >= 0; j--)
                    ans.append(str.charAt(j));
                System.out.println(ans);
            }
            t--;
        }
    }
}
