package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PairProgramming {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            br.readLine();
            String []knm=br.readLine().split(" ");
            int k=Integer.parseInt(knm[0]);
            int n=Integer.parseInt(knm[1]);
            int m=Integer.parseInt(knm[2]);
            int []a=new int[n];
            String []str=br.readLine().split(" ");
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int []b=new int[m];
            str=br.readLine().split(" ");
            for(int i=0;i<m;i++)
                b[i]=Integer.parseInt(str[i]);

            List<Integer> res=new ArrayList<>();
            int i=0,j=0;
            int lines = k;
            while(i<n){
                if(a[i]>0){
                    if(a[i]>lines){
                        while(j<m){
                            if(b[j]>0){
                                if(b[j]>lines) {
                                    break;
                                }
                            }else{
                                lines+=1;
                            }
                            res.add(b[j]);
                            j++;
                        }
                        //if still a[i]>lines, then problem is not solved and hence break
                        if(a[i]>lines){
                            break;
                        }
                    }
                }else{
                    lines+=1;
                }
                res.add(a[i]);
                i++;
            }

            if(i<n){
                System.out.println(-1);
                t--;
                continue;
            }
            while(j<m){
                if(b[j]>0){
                    if(b[j]>lines) {
                        break;
                    }
                }else{
                    lines+=1;
                }
                res.add(b[j]);
                j++;
            }
            if(j<m){
                System.out.println(-1);
                t--;
                continue;
            }
            StringBuilder ans=new StringBuilder();
            for(int e: res){
                ans.append(e).append(" ");
            }
            System.out.println(ans);
            t--;
        }
    }
}
