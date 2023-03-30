package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ABBalance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String s=br.readLine();
            //count no of ab's and ba's
            int ab=0, ba=0;
            for(int i=0;i<s.length()-1;i++){
                char c1=s.charAt(i);
                char c2=s.charAt(i+1);
                if(c1=='a' && c2=='b')
                    ab+=1;
                else if(c1=='b' && c2=='a')
                    ba+=1;
            }
            if(ab==ba){
                System.out.println(s);
            }else{
                assert(abs(ab-ba)==1);
                StringBuilder ans=new StringBuilder(s);
                if(ab>ba){
                   //it can start with (aa=>ba), (ab=>bb)
                    ans.setCharAt(0, 'b');
                }else {
                    //it can start with (bb=>ab), (ba=>aa)
                    ans.setCharAt(0,'a');
                }
                System.out.println(ans);
            }
            t--;
        }
    }
    private static int abs(int a){
        return a<0?-a:a;
    }
    private static void repeat(StringBuilder res, char c, int n) {
        for(int i = 0; i< n; i++) {
            res.append(c);
        }
    }
}
