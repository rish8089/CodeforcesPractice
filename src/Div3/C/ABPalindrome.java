package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ABPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0) {
            String[] ab = br.readLine().split(" ");
            int a=Integer.parseInt(ab[0]);
            int b=Integer.parseInt(ab[1]);
            String s=br.readLine();
            int n=s.length();
            char []ch=s.toCharArray();
            boolean flag=true;
            //primary level checks and evaluation
            for(int i=0;i<n/2;i++){
                if(ch[i] !='?' && ch[n-i-1] != '?'){
                    if(ch[i] != ch[n-i-1]){
                        flag=false;
                        break;
                    }
                } else if(ch[i] != '?'){
                    ch[n-i-1] = ch[i];
                } else if(ch[n-i-1] != '?'){
                    ch[i] = ch[n-i-1];
                }
            }
            if(!flag)
            {
                System.out.println(-1);
                t--;
                continue;
            }

            int rem=0;
            for(int i=0;i<n;i++){
                if(ch[i]=='0')
                    a-=1;
                else if(ch[i]=='1')
                    b-=1;
                else
                    rem+=1;
            }
            if(a<0 || b<0 || a+b != rem) {
                System.out.println(-1);
                t--;
                continue;
            }

            if(rem%2==0){
                if(a%2==0 && b%2==0){
                    for(int i=0;i<n/2;i++){
                        if(ch[i] == '?'){
                            if(a>1){
                                ch[i]='0';
                                ch[n-i-1]='0';
                                a-=2;
                            }else {
                                ch[i]='1';
                                ch[n-i-1]='1';
                                b-=2;
                            }
                        }
                    }
                }else{
                    System.out.println(-1);
                    t--;
                    continue;
                }
            } else{
                for(int i=0;i<n/2;i++){
                    if (ch[i] == '?') {
                        if(a>1){
                            ch[i]='0';
                            ch[n-i-1]='0';
                            a-=2;
                        }else {
                            ch[i]='1';
                            ch[n-i-1]='1';
                            b-=2;
                        }
                    }
                }
                ch[n/2]=a>0?'0':'1';
            }
            System.out.println(new String(ch));
            t--;
        }

    }
}
