package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuildThePermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nab=br.readLine().split(" ");
            int n=Integer.parseInt(nab[0]);
            int a=Integer.parseInt(nab[1]);
            int b=Integer.parseInt(nab[2]);
            if(a+b>n-2 || abs(a-b)>1)
                System.out.println(-1);
            else{
                StringBuilder ans=new StringBuilder();
                int min=1;
                int max=n;
                if(a>=b){
                    ans.append(min).append(" ");
                    min++;
                    for(int i=1;i<=a+b;i++){
                        if(i%2!=0) {
                            ans.append(max).append(" ");
                            max--;
                        }else{
                            ans.append(min).append(" ");
                            min++;
                        }
                    }

                }else{
                    ans.append(max).append(" ");
                    max--;
                    for(int i=1;i<=a+b;i++){
                        if(i%2!=0) {
                            ans.append(min).append(" ");
                            min++;
                        }
                        else {
                            ans.append(max).append(" ");
                            max--;
                        }
                    }

                }


                if(a>b){
                    while(max>=min){
                        ans.append(max).append(" ");
                        max--;
                    }
                }else{
                    while(min<=max){
                        ans.append(min).append(" ");
                        min++;
                    }
                }
                System.out.println(ans);
            }
            t--;
        }
    }
    private static int abs(int x){
        return x<0?-x:x;
    }
}
