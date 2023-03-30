package Div3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SampleFile {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int cnt=0;
//        for(int i=0;i<4;i++){
//            for(int j=0;j<4;j++){
//                for(int k=i;k<4;k++){
//                    for(int l=j;l<4;l++)
//                        cnt++;
//                }
//            }
//        }
//        System.out.println(cnt);
//        System.out.println(4^(4&3));
//        int sum=0;
//        int []a={1,2,3,4,5};
//        for(int i=0;i<5;i++){
//            int or=0;
//            for(int j=i;j<5;j++){
//                or=or|a[j];
//                sum+=or;
//                System.out.println(or);
//            }
//        }
//        System.out.println(sum);
        Map<Integer, Integer> mp=new HashMap<>();
        mp.put(1,1);
        System.out.println(mp.size());
        mp.keySet().remove(1);
        System.out.println(mp.size());

    }
}
