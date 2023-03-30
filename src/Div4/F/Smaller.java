package Div4.F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Smaller {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            long []hashs=new long[26];
            long []hasht=new long[26];
            hashs[0]=1;
            hasht[0]=1;
            int lens=1;
            int maxt='a';
            int q=Integer.parseInt(br.readLine());
            while(q>0) {
                String[] dkx = br.readLine().split(" ");
                int d = Integer.parseInt(dkx[0]);
                int k = Integer.parseInt(dkx[1]);
                String x = dkx[2];
                switch(d){
                    case 1:
                        for(int i=0;i<x.length();i++){
                            hashs[x.charAt(i)-'a']+=k;
                        }
                        lens+=k*x.length();
                        break;
                    case 2:
                        for(int i=0;i<x.length();i++) {
                            hasht[x.charAt(i) - 'a']+=k;
                            if (maxt < x.charAt(i))
                                maxt = x.charAt(i);
                        }
                }
                if(maxt>'a'){
                    System.out.println("YES");
                }else if(maxt=='a') {
                    if(hashs[0] > hasht[0])
                        System.out.println("NO");
                    else {
                        if(lens-hashs[0]>0){
                            System.out.println("NO");
                        }else{
                            System.out.println(hashs[0]<hasht[0]?"YES":"NO");
                        }
                    }
                }
                q--;
            }
            t--;
        }
    }
}
