package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HonestCoach {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(str[i]);
            }
            Arrays.sort(a);
            int minDiff = a[1]-a[0];
            for(int i=1;i<n-1;i++){
                if(minDiff>a[i+1]-a[i])
                    minDiff = a[i+1]-a[i];
            }
            System.out.println(minDiff);
            t--;
        }
    }
}
