package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArraySplitting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nk=br.readLine().split(" ");
        int n=Integer.parseInt(nk[0]);
        int k=Integer.parseInt(nk[1]);
        String []str=br.readLine().split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(str[i]);
        List<Element> list=new ArrayList<>();
        for(int i=1;i<n;i++)
            list.add(new Element(a[i]-a[i-1], i));
        Comparator<Element> c = (e1,e2)->{
            return Integer.compare(e1.diff, e2.diff);
        };
        Collections.sort(list, c.reversed());
        List<Element> sortedPartitionList = new ArrayList<>();
        for(int i=0;i<k-1;i++)
            sortedPartitionList.add(list.get(i));
        Collections.sort(sortedPartitionList, (e1,e2)->{
            return Integer.compare(e1.idx, e2.idx);
        });
        int startPos=0;
        long cost=0;
        for(int i=0;i<k-1;i++){
            //traverse from startPos to sortedPartitionList.get(i)-1
            Element e = sortedPartitionList.get(i);
            cost+=a[e.idx-1]-a[startPos];
            startPos = e.idx;
        }
        cost+=a[n-1]-a[startPos];
        System.out.println(cost);
    }

    private static class Element{
        int diff;
        int idx;
        Element(int diff, int idx){
            this.diff=diff;
            this.idx=idx;
        }
    }
}
