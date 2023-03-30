package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class YetAnotherBrokenKeyboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nk=br.readLine().split(" ");
        int n= Integer.parseInt(nk[0]);
        int k=Integer.parseInt(nk[1]);
        String s=br.readLine();
        String []charactersAllowed = br.readLine().split(" ");
        Set<Character> set=new HashSet<>();
        for(int i=0;i<k;i++)
            set.add(charactersAllowed[i].charAt(0));
        long cnt=0;
        long ans=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(!set.contains(c)) {
                ans+=cnt*(cnt+1)/2;
                cnt=0;
                while(i+1<n && !set.contains(s.charAt(i+1))){
                    i++;
                }
            }else{
                cnt++;
            }
        }
        if(cnt>0){
            ans+=cnt*(cnt+1)/2;
        }
        System.out.println(ans);
    }
}
