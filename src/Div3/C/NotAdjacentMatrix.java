package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotAdjacentMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] temp ={{2,9,7},{4,6,3},{1,8,5}};
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            if(n==1)
                System.out.println(1);
            else if(n==2)
                System.out.println(-1);
            else{
                int [][]res=new int[n][n];
                for(int i=0;i<n-3;i++){
                    //traversing ith column from ith row
                    for(int j=i;j<n;j++){
                        res[j][i]=(n-i)*(n-i)-(j-i)*2;
                    }
                    //traversing ith row from (i+1)th column
                    for(int j=n-1;j>i;j--){
                        res[i][j]=((n-i)*(n-i)-1)-(n-1-j)*2;
                    }
                }
                for(int i=n-3;i<n;i++){
                    for(int j=n-3;j<n;j++){
                        res[i][j]=temp[i-(n-3)][j-(n-3)];
                    }
                }
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        System.out.print(res[i][j]+ " ");
                    }
                    System.out.println();
                }
            }
            t--;
        }
    }
}
