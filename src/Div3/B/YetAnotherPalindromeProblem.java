package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class YetAnotherPalindromeProblem {
    final static int HASHLIM= 5000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0){
            int n= Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int []hash=new int[HASHLIM+1];
            Arrays.fill(hash,-1);
            boolean res=false;
            //determine if duplicate exists with atleast the distance of 1
            for(int i=0;i<n;i++){
                if(hash[a[i]]==-1){
                    hash[a[i]]=i;
                }else{
                    if(i-hash[a[i]]>1){
                        res=true;
                        break;
                    }
                }
            }
            System.out.println(res?"YES":"NO");
            t--;
        }
    }
}
