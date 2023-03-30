//package Div4.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrependAndAppend {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            int i=0;
            int j=s.length()-1;
            while(i<j){
                if((s.charAt(i)=='0' && s.charAt(j)=='1') || (s.charAt(i)=='1' && s.charAt(j)=='0')){
                    i++;
                    j--;
                }else{
                    break;
                }
            }
            System.out.println(j-i+1);
            t--;
        }
    }
}
