package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NekoPerformsCatFurrierTransform {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        List<Integer> list=new ArrayList<>();
        int i=0;
        while ((x & (x + 1)) != 0) {
            if(i%2==0) {
                int cnt = 0;
                int temp = x;
                while ((temp & 1) == 0) {
                    cnt++;
                    temp = temp >> 1;
                }
                list.add(cnt);
                x = x ^ ((1 << cnt) - 1);
            }else{
                x=x+1;
            }
            i++;
        }
        System.out.println(i);
        for(int e:list)
            System.out.print(e+" ");
    }
}
