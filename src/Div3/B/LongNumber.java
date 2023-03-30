package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String s=br.readLine();
        String []str=br.readLine().split(" ");
        int []a=new int[9];
        for(int i=0;i<9;i++)
            a[i]=Integer.parseInt(str[i]);
        StringBuilder ans=new StringBuilder();
        boolean operationDone = false;
        for(int i=0;i<s.length();i++){
            int d=s.charAt(i)-'0';
            if(!operationDone){
                if(a[d-1]>d){
                    ans.append(a[d-1]);
                    while(i+1<s.length()){
                        d=s.charAt(i+1)-'0';
                        if(a[d-1]>=d)
                            ans.append(a[d-1]);
                        else
                            break;
                        i++;
                    }
                    operationDone=true;
                }else ans.append(d);
            }else
                ans.append(d);
        }
        System.out.println(ans);
    }
}
