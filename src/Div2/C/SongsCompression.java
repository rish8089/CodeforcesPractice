//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SongsCompression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nm=br.readLine().split(" ");
        int n=Integer.parseInt(nm[0]);
        int m=Integer.parseInt(nm[1]);
        List<Node> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String []ab= br.readLine().split(" ");
            list.add(new Node(Integer.parseInt(ab[0]),Integer.parseInt(ab[1])));
        }
        Collections.sort(list, (n1,n2)->Integer.compare(n2.a-n2.b, n1.a-n1.b));
        long initialSum = 0;
        for(Node elem:list) {
            initialSum += elem.a;
        }
        int cnt=0;
        for(int i=0;i<n && initialSum>m;i++){
            Node nd = list.get(i);
            initialSum = initialSum - (nd.a - nd.b);
            cnt++;
        }
        System.out.println(initialSum<=m?cnt:-1);
    }
    private static class Node{
        int a;
        int b;
        Node(int a, int b){
            this.a=a;
            this.b=b;
        }
    }
}
