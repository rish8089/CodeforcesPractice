package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Portal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []ab=br.readLine().split(" ");
            int n=Integer.parseInt(ab[0]);
            int m=Integer.parseInt(ab[1]);
            String []rec=new String[n];
            for(int i=0;i<n;i++){
                rec[i]=br.readLine();
            }
            int [][]columnSum=new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j == 0)
                        columnSum[i][j] = rec[i].charAt(j) == '1' ? 1 : 0;
                    else
                        columnSum[i][j] = columnSum[i][j - 1] + (rec[i].charAt(j) == '1' ? 1 : 0);
                }
            }
            for (int i = 1; i < m - 2; i++) {
                for (int j = i + 1; j < m - 1; j++) {
                    Map<Integer, Node> mp = new HashMap<>();

                }
            }
            t--;
        }
    }

    private static class Node {
        int startpos;
        int endpos;

        Node(int startpos, int endpos) {
            this.startpos = startpos;
            this.endpos = endpos;
        }
    }
}
