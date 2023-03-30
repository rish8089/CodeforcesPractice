//  package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConstructARectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []l1l2l3=br.readLine().split(" ");
            int l1=Integer.parseInt(l1l2l3[0]);
            int l2=Integer.parseInt(l1l2l3[1]);
            int l3=Integer.parseInt(l1l2l3[2]);
            if(l1==l2){
                System.out.println(l3%2==0?"YES":"NO");
            }else if(l1==l3){
                System.out.println(l2%2==0?"YES":"NO");
            }else if(l2==l3){
                System.out.println(l1%2==0?"YES":"NO");
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(l1);
                list.add(l2);
                list.add(l3);
                Collections.sort(list);
                if(list.get(0)+list.get(1)==list.get(2))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            t--;
        }
    }
}
