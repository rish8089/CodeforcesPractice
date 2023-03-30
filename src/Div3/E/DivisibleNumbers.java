//package Div3.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DivisibleNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []abcd=br.readLine().split(" ");
            int a=Integer.parseInt(abcd[0]);
            int b=Integer.parseInt(abcd[1]);
            int c=Integer.parseInt(abcd[2]);
            int d=Integer.parseInt(abcd[3]);
            long num=(long)a*b;
            List<Node> factors=new ArrayList<>();
            for(long i=2;i*i<=num;i++){
                int cnt=0;
                while(num%i==0){
                    cnt++;
                    num/=i;
                }
                if(cnt>0) {
                    factors.add(new Node(i, cnt));
                }
            }
            if(num>1){
                factors.add(new Node(num,1));
            }
            ArrayList<Long> res=processCombinations(factors, 0, a,b,c,d,1,1);
            if(res.size()==0){
                System.out.println("-1 -1");
            }else{
                System.out.println(res.get(0)+" "+res.get(1));
            }
            t--;
        }
    }
    private static ArrayList<Long> processCombinations(List<Node> factors, int currIdx, long a, long b, long c, long d,
                                                          long num1, long num2){
        ArrayList<Long> res=new ArrayList<>();
        if(currIdx==factors.size()){
            if(num1<=a){
                num1=c/num1*num1;
            }
            if(num2<=b){
                num2=d/num2*num2;
            }
            if((num1>a && num1<=c) && (num2>b && num2<=d)){
                res.add(num1);
                res.add(num2);
            }
            return res;
        }
        Node node=factors.get(currIdx);
        long prod=1;
        long totalVal=mypow(node.primeFactor, node.power);
        for (int i = 0; i <= node.power; i++) {
            if(i>=1) {
                prod = prod * node.primeFactor;
            }
            res=processCombinations(factors, currIdx + 1, a, b, c, d, num1 * prod, num2 * (totalVal / prod));
            if(res.size()>0)
                return res;
        }
        return res;
    }
    static class Node{
        long primeFactor;
        int power;
        Node(long primeFactor, int power){
            this.primeFactor=primeFactor;
            this.power=power;
        }
    }
    private static long mypow(long base, int power){
//        if(power==0)
//            return 1;
//        long res=mypow(base, power/2);
//        if(power%2==0)
//            return res*res;
//        else
//            return res*res*base;
        long res=1;
        while(power>0){
            if(power%2!=0)
                res=res*base;
            power=power/2;
            if(power>0){
                base=base*base;
            }
        }
        return res;
    }
}
