package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OddSumSegments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String []nk=br.readLine().split(" ");
            int n=Integer.parseInt(nk[0]);
            int k=Integer.parseInt(nk[1]);
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            List<Integer> ans=new ArrayList<>();
            int currSum=0;
            for(int i=0;i<n;i++){
                currSum+=a[i];
                if(currSum%2!=0){
                    if(k>1) {
                        ans.add(i + 1);
                        currSum = 0;
                        k--;
                    }
                }
            }
            if(k==1 && currSum%2!=0){
                System.out.println("YES");
                ans.add(n);
                for(int e:ans){
                    System.out.print(e+ " ");
                }
                System.out.println();
            }else{
                System.out.println("NO");
            }
            t--;
        }
    }
}
