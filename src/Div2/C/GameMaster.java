//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GameMaster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());

            String[] str = br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);

            str = br.readLine().split(" ");
            int []b=new int[n];
            for(int i=0;i<n;i++)
                b[i]=Integer.parseInt(str[i]);


            TreeSet<Node> atree = new TreeSet<>((n1,n2)->{
                return Integer.compare(n1.aval, n2.aval);
            });
            for(int i=0;i<n;i++) {
                atree.add(new Node(a[i], b[i], i));
            }
            TreeSet<Node> btree = new TreeSet<>((n1,n2)->{
                return Integer.compare(n1.bval, n2.bval);
            });
            for(int i=0;i<n;i++) {
                btree.add(new Node(a[i], b[i], i));
            }
            boolean []visited=new boolean[n];
            bfs(atree, btree, visited);
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<n;i++){
                ans.append(visited[i]?'1':'0');
            }
            System.out.println(ans);
            t--;
        }

    }
    private static class Node{
        int aval;
        int bval;
        int pos;
        Node(int aval, int bval, int pos){
            this.aval=aval;
            this.bval=bval;
            this.pos=pos;
        }
    }

    private static void bfs(TreeSet<Node> a, TreeSet<Node> b, boolean []visited){
        Queue<Node> q = new LinkedList<>();
        Node lastOfA = a.last();
        q.add(lastOfA);
        visited[lastOfA.pos] = true;
        a.remove(lastOfA);

        Node lastOfB = b.last();
        if (!visited[lastOfB.pos]) {
            q.add(lastOfB);
            visited[lastOfB.pos] = true;
            b.remove(lastOfB);
        }
        while(!q.isEmpty()){
            Node nd=q.poll();
            Node higher = a.higher(nd);
            while(higher!=null && !visited[higher.pos]){
                q.add(higher);
                visited[higher.pos]=true;
                a.remove(higher);
                higher = a.higher(nd);
            }
            higher = b.higher(nd);
            while(higher !=null && !visited[higher.pos]){
                q.add(higher);
                visited[higher.pos]=true;
                b.remove(higher);
                higher = b.higher(nd);
            }
        }
    }

}
