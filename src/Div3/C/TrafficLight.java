//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nc=br.readLine().split(" ");
            int n=Integer.parseInt(nc[0]);
            char c=nc[1].charAt(0);
            String s=br.readLine();
            if(c=='g')
                System.out.println(0);
            else {
                int pos = -1;//position of char c after which g is not there
                int max = 0;
                for (int i = 0; i < n; i++) {
                    char x = s.charAt(i);
                    if (x == c) {
                        //start searching for 'g'
                        int j = i;
                        while (i + 1 < n && s.charAt(i + 1) != 'g') {
                            i++;
                        }
                        if (i == n - 1) {
                            //not able to find 'g'
                            pos = j;
                        } else {
                            //we found 'g'
                            if (max < i - j + 1)
                                max = i - j + 1;
                        }
                    }
                }
                if (pos != -1) {
                    //find the first occurrence of 'g'
                    for (int i = 0; i < n; i++) {
                        if (s.charAt(i) == 'g') {
                            if (max < n - pos + i) {
                                max = n - pos + i;
                            }
                            break;
                        }

                    }
                }
                System.out.println(max);
            }
            t--;
        }
    }
}
