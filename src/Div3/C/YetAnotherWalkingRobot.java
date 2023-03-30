//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class YetAnotherWalkingRobot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            Sum []prefixSum = new Sum[n];
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                prefixSum[i]=new Sum();
                prefixSum[i].v=i>0?prefixSum[i-1].v:0;
                prefixSum[i].h=i>0?prefixSum[i-1].h:0;
                if(c=='L') {
                    prefixSum[i].h-=1;
                }
                else if(c=='R') {
                    prefixSum[i].h+=1;
                }
                if(c=='U') {
                    prefixSum[i].v+=1;
                }
                if(c=='D') {
                    prefixSum[i].v-=1;
                }

            }
            Sum suffixPrevSum=new Sum();
            Map<Sum, List<Integer>> suffixSumsMap=new HashMap<>();
            for(int i=s.length()-1;i>=0;i--){
                char c=s.charAt(i);
                Sum suffixCurrentSum = new Sum();
                suffixCurrentSum.v=suffixPrevSum.v;
                suffixCurrentSum.h=suffixPrevSum.h;
                if(c=='L') {
                    suffixCurrentSum.h-=1;
                }
                else if(c=='R') {
                    suffixCurrentSum.h+=1;
                }
                if(c=='U') {
                    suffixCurrentSum.v+=1;
                }
                if(c=='D') {
                    suffixCurrentSum.v-=1;
                }
                if(suffixSumsMap.containsKey(suffixCurrentSum)){
                    List<Integer> list=suffixSumsMap.get(suffixCurrentSum);
                    list.add(i);
                }else{
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    suffixSumsMap.put(suffixCurrentSum, list);
                }
                suffixPrevSum=suffixCurrentSum;
            }
            Sum totalSum = new Sum();
            totalSum.h = prefixSum[n-1].h;
            totalSum.v= prefixSum[n-1].v;

            Endpoint ep=new Endpoint();
            int ans=-1;
            for(int i=0;i<n;i++){
                Sum suffixSumToFind = new Sum();
                suffixSumToFind.h = totalSum.h-prefixSum[i].h;
                suffixSumToFind.v = totalSum.v-prefixSum[i].v;
                if(suffixSumsMap.containsKey(suffixSumToFind)){
                    List<Integer> list=suffixSumsMap.get(suffixSumToFind);
                    int ubi = findUpperBoundIndex(list, i+1);
                    if(ubi!=-1){//found some suffix
                        if(ans==-1 || ans>ubi-i-1) {
                            ep.i=i+1;
                            ep.j=ubi-1;
                            ans = ubi-i-1;
                        }
                    }else{
                        if(suffixSumToFind.h==0 && suffixSumToFind.v==0 && i<n-1){
                            if(ans==-1 || ans>n-i-1) {
                                ep.i = i+1;
                                ep.j= n-1;
                                ans = n-i-1;
                            }
                        }
                    }
                    //check for no prefix sum as well
                    if(prefixSum[i].h==0 && prefixSum[i].v==0){
                        if(ans==-1 || ans>i+1){
                            ep.i=0;
                            ep.j=i;
                            ans=i+1;
                        }
                    }
                }
            }
            if(ans==-1)
                System.out.println(-1);
            else
                System.out.println((ep.i+1)+ " " + (ep.j+1));

            t--;
        }
    }

    private static int findUpperBoundIndex(List<Integer> list, int val){
        int ans=-1;
        int u=0;
        int v=list.size()-1;
        while(u<=v){
            int mid=(u+v)/2;
            if(list.get(mid)>val){
                u=mid+1;
                ans=list.get(mid);
            }else{
                v=mid-1;
            }
        }
        return ans;
    }

    private static class Endpoint{
        int i;
        int j;
    }
    private static class Sum{
        int v;
        int h;
        Sum(){
            v=0;
            h=0;
        }

        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if ((obj == null) || (obj.getClass() != this.getClass()))
                return false;
            // object must be Test at this point
            Sum sum = (Sum) obj;
            return v == sum.v && h == sum.h;
        }

        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + v;
            hash = 31 * hash + h;
            return hash;
        }

    }
}
