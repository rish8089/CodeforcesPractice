//package Div3.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CopyOfACopyOfACopy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nmk=br.readLine().split(" ");
        int n=Integer.parseInt(nmk[0]);
        int m=Integer.parseInt(nmk[1]);
        int k=Integer.parseInt(nmk[2]);
        char [][][]A=new char[k+1][n][m];
        ArrayList<ArrayList<Node>> list=new ArrayList<>();
        for(int i=0;i<k+1;i++)
            list.add(new ArrayList<>());
        for(int i=0;i<k+1;i++) {
            br.readLine();
            for (int j=0;j<n;j++) {
                String str = br.readLine();
                for (int l=0;l<m;l++) {
                    A[i][j][l]=str.charAt(l);
                }
            }
        }
        int []inwardEdges=new int[k+1];
        for(int i=0;i<k+1;i++){
            for(int j=0;j<k+1;j++){
                if(i!=j){

                }
            }
        }
        //find out a node which is having 0 degree of first operations
        int source=-1;
        for(int i=0;i<k+1;i++){
            if(inwardEdges[i]==0){
                source=i;
                break;
            }
        }
        if(source==-1) {
            System.out.println("Some issue");
            return;
        }
        Set<Integer> visited=new HashSet<>();
        visited.add(source);
        ArrayList<Node> ans=new ArrayList<>();
        dfs(list, source, ans, visited);
        int op=0;
        for(int i=0;i<ans.size();i++){
            Node nd=ans.get(i);
            if(nd.op==1)
                op+=2;
            else
                op+=1;
        }
        System.out.println(source+1);
        System.out.println(op);
        for(int i=0;i<ans.size();i++){
            Node nd=ans.get(i);
            if(nd.op==2)
                System.out.println(nd.op+" "+(nd.idx+1));
            else {
                System.out.println(nd.op + " " + (nd.x + 1) + " " + (nd.y + 1));
                System.out.println(2 + " "+(nd.idx+1));
            }
        }
    }
    private static void dfs(ArrayList<ArrayList<Node>> list, int source, ArrayList<Node> ans, Set<Integer> visited){
        for(int i=0;i<list.get(source).size();i++){
            Node child=list.get(source).get(i);
            if(!visited.contains(child.idx)){
                visited.add(child.idx);
                ans.add(child);
                dfs(list, child.idx, ans, visited);
            }
        }
    }
    static class Node{
        int op;
        int idx;
        int x;
        int y;
        Node(int op, int idx, int x, int y){
            this.op=op;
            this.idx=idx;
            this.x=x;
            this.y=y;
        }
    }
}
