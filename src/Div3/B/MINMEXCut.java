package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MINMEXCut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String str=br.readLine();
            List<Integer> sols=new ArrayList<>();
            sols.add(0);
            sols.add(1);
            sols.add(2);
            for(int i=0;i<str.length();i++){
                int val=str.charAt(i)-'0';
                if(sols.contains(val)){
                    sols.remove(Integer.valueOf(val));
                }
            }
            int probableSolution = sols.get(0);
            int probableSolution2 = 0;
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if(c=='0'){
                    while(i+1<str.length() && str.charAt(i+1)=='0')
                        i++;
                    probableSolution2+=1;
                }
            }
            System.out.println(Math.min(probableSolution, probableSolution2));
            t--;
        }
    }
}
