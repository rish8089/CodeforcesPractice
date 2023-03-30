//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ticks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nmk=br.readLine().split(" ");
            int n=Integer.parseInt(nmk[0]);
            int m=Integer.parseInt(nmk[1]);
            int k=Integer.parseInt(nmk[2]);
            char [][]ch=new char[n][m];
            for(int i=0;i<n;i++){
                String s=br.readLine();
                for(int j=0;j<m;j++){
                    ch[i][j]=s.charAt(j);
                }
            }
            List<Entry> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(ch[i][j]=='*'){
                        //check if tick can be created and get its size
                        int l=1;
                        while(i-l>=0 && j-l>=0 && j+l<m && ch[i-l][j-l]=='*' && ch[i-l][j+l]=='*'){
                            l++;
                        }
                        if(l-1>=k){
                            list.add(new Entry(i,j,l-1));
                        }
                    }
                }
            }
            Collections.sort(list, (e1,e2)-> Integer.compare(e2.val,e1.val));
            char [][]res=new char[n][m];
            for(Entry e:list){
                res[e.x][e.y]='*';
                for(int i=1;i<=e.val;i++){
                    res[e.x-i][e.y-i]='*';
                    res[e.x-i][e.y+i]='*';
                }
            }
            boolean flag=true;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(ch[i][j]=='*') {
                        if (res[i][j] != ch[i][j]) {
                            flag = false;
                            break;
                        }
                    }
                }
                if(!flag)
                    break;
            }
            System.out.println(flag?"YES":"NO");
            t--;
        }
    }

    private static class Entry{
        int val;
        int x;
        int y;
        Entry(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
    }
}
