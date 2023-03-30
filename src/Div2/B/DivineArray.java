package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DivineArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            List<List<Integer>> list=new ArrayList<>();
            List<Integer> initialList=new ArrayList<>();
            for(int i=0;i<n;i++)
                initialList.add(a[i]);
            list.add(initialList);
            int step=1;
            while(true){
                int []hash=new int[n+1];
                for(int i=0;i<n;i++){
                    hash[a[i]]++;
                }
                List<Integer> transformedList=new ArrayList<>();
                for(int i=0;i<n;i++){
                    a[i]=hash[a[i]];
                    transformedList.add(a[i]);
                }
                //check if transformed list and prev list are same
                List<Integer> prevList = list.get(step-1);
                boolean flag= true;
                for(int i=0;i<n;i++){
                    if(!transformedList.get(i).equals(prevList.get(i))){
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    break;
                list.add(transformedList);
                step++;
            }
            int q=Integer.parseInt(br.readLine());
            while(q>0){
                String []xk=br.readLine().split(" ");
                int x=Integer.parseInt(xk[0]);
                int k=Integer.parseInt(xk[1]);
                if(k>=list.size()-1){
                    k=list.size()-1;
                }
                System.out.println(list.get(k).get(x-1));
                q--;
            }
            t--;
        }
    }
}
