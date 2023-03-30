package Div3.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZeroOneSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            List<Integer> zeroList= new ArrayList<>();
            List<Integer> oneList= new ArrayList<>();
            for(int i=0;i<n;i+=2)
                zeroList.add(a[i]);
            for(int i=1;i<n;i+=2)
                oneList.add(a[i]);
            zeroList.sort(Collections.reverseOrder());
            Collections.sort(oneList);
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(i%2==0)
                    list.add(zeroList.get(i/2));
                else
                    list.add(oneList.get(i/2));
            }
            long subseqs=0;
            int ones=0;
            for(int i=list.size()-1;i>=0;i--){
                if(i%2==0){
                    subseqs+=list.get(i)*ones;
                }else{
                    ones+=list.get(i);
                }
            }
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<list.size();i++){
                ans.append(list.get(i)).append(" ");
            }
            System.out.println(ans);
            System.out.println(subseqs);
            t--;
        }
    }
}
