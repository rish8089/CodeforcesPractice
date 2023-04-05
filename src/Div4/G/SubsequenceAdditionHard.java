//package Div4.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SubsequenceAdditionHard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            ArrayList<Integer> list=new ArrayList<>();
            for (int i = 0; i < n; i++)
                list.add(Integer.parseInt(str[i]));
            Collections.sort(list);
            if(list.get(0)!=1)
                System.out.println("NO");
            else {
                long s=1;
                boolean flag=true;
                for (int i = 1; i < n; i++) {
                    if(list.get(i)>s){
                        flag=false;
                        break;
                    }
                    s+=list.get(i);
                }
                System.out.println(flag?"YES":"NO");
            }
            t--;
        }
    }
}
