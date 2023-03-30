package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlmostRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            char[][] mat = new char[n][n];
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++)
                    mat[i][j] = str.charAt(j);
            }
            int row1 = -1, col1 = -1, row2 = -1, col2 = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == '*') {
                        if (row1 == -1) {
                            row1 = i;
                            col1 = j;
                        } else {
                            row2 = i;
                            col2 = j;
                        }
                    }
                }
            }

            if (row1 != row2 && col1 != col2) {
                mat[row2][col1] = '*';
                mat[row1][col2] = '*';
            } else if (row1 != row2) {
                int col;
                if (col1 - 1 >= 0)
                    col = col1 - 1;
                else
                    col = col1 + 1;
                mat[row1][col] = '*';
                mat[row2][col] = '*';
            } else if (col1 != col2) {
                int row;
                if (row1 - 1 >= 0)
                    row = row1 - 1;
                else
                    row = row1 + 1;
                mat[row][col1] = '*';
                mat[row][col2] = '*';
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    System.out.print(mat[i][j]);
                System.out.println();
            }
            t--;
        }
    }
}

