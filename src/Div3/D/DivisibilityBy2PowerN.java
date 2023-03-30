//package Div3.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisibilityBy2PowerN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int sumOfPowersOfTwo=0;
            for(int i=0;i<n;i++){
                sumOfPowersOfTwo+=powerOfTwo(a[i]);
            }
            if(sumOfPowersOfTwo>=n)
                System.out.println(0);
            else{
                int requiredPowers=n-sumOfPowersOfTwo;
                List<Integer> list=new ArrayList<>();
                for(int i=1;i<=n;i++){
                    list.add(powerOfTwo(i));
                }
                Collections.sort(list, Collections.reverseOrder());
                int ans=0;
                for(int i=0;i<list.size() && requiredPowers>0;i++){
                    requiredPowers=requiredPowers-list.get(i);
                    ans++;
                }
                System.out.println(requiredPowers>0?-1:ans);
            }
            t--;
        }

    }
    private static int powerOfTwo(int num){
        int power=0;
        while(num>0 && num%2==0){
            power++;
            num/=2;
        }
        return power;
    }
}
