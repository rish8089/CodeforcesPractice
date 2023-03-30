package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DislikeOfThrees {
    private static final int LIM=1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int []res=new int[LIM+1];
        for(int i=1, j=1;j<=LIM;i++){
            int d=i%10;
            if(d!=3 && i%3!=0){
                res[j]=i;
                j++;
            }
        }
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int k=Integer.parseInt(br.readLine());
            System.out.println(res[k]);
            t--;
        }
    }
}
