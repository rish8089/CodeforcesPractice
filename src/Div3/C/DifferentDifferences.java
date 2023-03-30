//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DifferentDifferences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []kn=br.readLine().split(" ");
            int k=Integer.parseInt(kn[0]);
            int n=Integer.parseInt(kn[1]);
            int diff=n-k;
            int count=apCount(diff);
            int countOfNumbersToShift=Math.min(k-2,count);
            StringBuilder res=new StringBuilder();
            for(int i=1;i<=k-countOfNumbersToShift;i++)
                res.append(i).append(" ");
            int lastNum=k-countOfNumbersToShift;
            for(int i=1;i<=countOfNumbersToShift;i++){
                lastNum=lastNum+i+1;
                res.append(lastNum).append(" ");
            }
            System.out.println(res);
            t--;
        }


    }
    private static int apCount(int sum){
        return (int)((-1+Math.sqrt(1+8*sum))/2.0);
    }
}
