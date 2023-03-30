package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SaveMoreMice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n,k;
            String []nk=br.readLine().split(" ");
            n=Integer.parseInt(nk[0]);
            k=Integer.parseInt(nk[1]);
            List<Integer> a=new ArrayList<>();
            String []str=br.readLine().split(" ");
            for(int i=0;i<k;i++){
                a.add(Integer.parseInt(str[i]));
            }
            Collections.sort(a);
            long moves=0;
            int mice=0;
            for(int i=k-1;i>=0;i--){
                if(moves<a.get(i)){
                    moves+=n-a.get(i);
                    mice+=1;
                }else{
                    break;
                }
            }

            System.out.println(mice);
            t--;
        }
    }
}