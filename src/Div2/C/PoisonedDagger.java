//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PoisonedDagger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String []nh=br.readLine().split(" ");
            int n=Integer.parseInt(nh[0]);
            long h=Long.parseLong(nh[1]);
            String []str=br.readLine().split(" ");
            int []time=new int[n];
            for(int i=0;i<n;i++)
                time[i]=Integer.parseInt(str[i]);
            long u=1;
            long v=Long.MAX_VALUE;
            long ans=-1;
            while(u<=v){
                long mid=u+(v-u)/2;
                if(checkIfDragonCanBeSlayed(time, n, mid, h)){
                    ans=mid;
                    v=mid-1;
                }else
                    u=mid+1;
            }
            System.out.println(ans);
            t--;
        }
    }
    private static boolean checkIfDragonCanBeSlayed(int []time, int n, long k, long h){
        long damage=0;
        for(int i=0;i<n && damage<h;i++){
            if(i<n-1){
                damage+=Long.min(time[i+1]-time[i],k);
            }else
                damage+=k;
        }
        return damage>=h;
    }
}
