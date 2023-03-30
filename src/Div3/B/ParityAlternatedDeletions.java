package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParityAlternatedDeletions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(str[i]);
        List<Integer> e=new ArrayList<>();
        List<Integer> o=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(a[i]%2==0)
                e.add(a[i]);
            else
                o.add(a[i]);
        }
        Collections.sort(e);
        Collections.sort(o);
        int ans=0;
        if(e.size()>o.size()){
            for(int i=0;i<e.size()-o.size()-1;i++){
                ans=ans+e.get(i);
            }
        }else{
            for(int i=0;i<o.size()-e.size()-1;i++){
                ans=ans+o.get(i);
            }
        }
        System.out.println(ans);
    }
}
