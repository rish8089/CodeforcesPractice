//package Div4.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubsequenceAdditionEasy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            Arrays.sort(a);
            boolean [][]mat=new boolean[a[n-1]+1][n];
            if(a[0]!=1){
                System.out.println("NO");
            }else{
                Arrays.fill(mat[1], true);
                for(int i=2;i<=a[n-1];i++){
                    for(int j=1;j<n;j++){
                        if(mat[i][j-1])
                            mat[i][j]=true;
                        else if(a[j]<i){
                            mat[i][j]=mat[i-a[j]][j-1];
                        }
                    }
                }
                boolean flag=true;
                for(int i=0;i<n;i++){
                    if(!mat[a[i]][n-1]){
                        flag=false;
                        break;
                    }
                }
                System.out.println(flag?"YES":"NO");
            }
            t--;
        }
    }
}
