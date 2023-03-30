package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrogJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String s=br.readLine();
            int []rindex = new int[s.length()];
            for(int i=1;i<s.length();i++){
                char c=s.charAt(i-1);
                if(c=='L'){
                    rindex[i]=rindex[i-1];
                }else{
                    rindex[i]=i;
                }
            }
            int u=1;
            int v=s.length()+1;
            int ans=-1;
            while(u<=v){
                int mid=(u+v)/2;
                if(checkIfFrogCanJumpToEnd(s,mid,rindex)){
                    v=mid-1;
                    ans=mid;
                }else{
                    u=mid+1;
                }
            }
            System.out.println(ans);
            t--;
        }
    }
    private static boolean checkIfFrogCanJumpToEnd(String s, int d, int[]rindex) {
        int currPos = d;
        boolean []visited=new boolean[s.length()+2];
        visited[currPos]=true;
        while (currPos != s.length() + 1 && currPos != 0) {
            char c=s.charAt(currPos-1);
            if(c=='R'){
                currPos = Math.min(currPos+d, s.length()+1);
            }else{
                currPos = rindex[currPos-1];
            }
            if(!visited[currPos]){
                visited[currPos]=true;
            }else
                break;
        }
        return currPos==s.length()+1;
    }
}
