//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TokitsukazeAndGood01StringEasy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                int cnt=1;
                while(i+1<n && s.charAt(i)==s.charAt(i+1)){
                    cnt++;
                    i++;
                }
                list.add(cnt);
            }
            int operations = 0;
            for(int i=0;i<list.size()-1;){
                int cnt1=list.get(i);
                int cnt2=list.get(i+1);
                if(cnt1%2==0 && cnt2%2==0){
                    i+=2;
                }else if(cnt1%2!=0 && cnt2%2!=0){
                    i+=2;
                    operations+=1;
                }else if(cnt1%2==0 && cnt2%2!=0){
                    i+=1;
                }else {
                    operations+=1;
                    list.set(i+1, cnt2-1);
                    i+=1;
                }
            }
            System.out.println(operations);
            t--;
        }
    }
}
