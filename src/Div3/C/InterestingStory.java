package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InterestingStory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []words=new String[n];
            for(int i=0;i<n;i++)
                words[i]=br.readLine();
            char []letters={'a','b','c','d','e'};
            int maxWords=0;
            for(int i=0;i<letters.length;i++){
                char c= letters[i];
                Arrays.sort(words,(word1,word2)->{
                    int currentLetterCountInWord1=giveLetterCountInGivenWord(word1,c);
                    int otherLetterCountInWord1 = word1.length()- currentLetterCountInWord1;
                    int currentLetterCountInWord2=giveLetterCountInGivenWord(word2,c);
                    int otherLetterCountInWord2 = word2.length()- currentLetterCountInWord2;
                    return Integer.compare(currentLetterCountInWord2-otherLetterCountInWord2, currentLetterCountInWord1-otherLetterCountInWord1);
                });
                int otherLetterCount=0;
                int currentLetterCount=0;
                int maxVal=0;
                for(int j=0;j<words.length;j++) {
                    for (int k = 0; k < words[j].length(); k++) {
                        if (words[j].charAt(k) == c) {
                            currentLetterCount++;
                        } else {
                            otherLetterCount++;
                        }
                    }
                    if(currentLetterCount>otherLetterCount){
                        maxVal=j+1;
                    }else{
                        break;
                    }
                }
                if(maxWords<maxVal)
                    maxWords=maxVal;
            }
            System.out.println(maxWords);
            t--;
        }
    }

    private static int giveLetterCountInGivenWord(String word, char letter){
        int cnt=0;
        for(int j=0;j<word.length();j++){
            if(word.charAt(j)==letter)
                cnt++;
        }
        return cnt;
    }
}
