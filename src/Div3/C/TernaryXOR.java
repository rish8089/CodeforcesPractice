//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TernaryXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            boolean encounteredOne=false;
            char []a=new char[n];
            char []b=new char[n];
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(c=='2'){
                    if(encounteredOne){
                        a[i]='0';
                        b[i]='2';
                    }else{
                        a[i]='1';
                        b[i]='1';
                    }
                }else if(c=='1'){
                    if(encounteredOne) {
                        a[i] = '0';
                        b[i]='1';
                    }else{
                        a[i]='1';
                        b[i]='0';
                        encounteredOne=true;
                    }

                }else{
                    a[i]='0';
                    b[i]='0';
                }
            }
            System.out.println(new String(a));
            System.out.println(new String(b));
            t--;
        }

    }
}
