package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TanyaAndCandies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(str[i]);
        Node[] sumtill = new Node[n];
        for (int i = 0; i < n; i++) {
            sumtill[i] = new Node();
            if (i > 0) {
                if ((i + 1) % 2 == 0) {
                    sumtill[i].even += sumtill[i - 1].even + a[i];
                    sumtill[i].odd = sumtill[i-1].odd;
                } else {
                    sumtill[i].odd += sumtill[i - 1].odd + a[i];
                    sumtill[i].even=sumtill[i-1].even;
                }
            } else {
                sumtill[i].odd += a[i];
            }
        }
        Node[] sumfromAsOdd = new Node[n];
        for(int i=n-1;i>=0;i--){
            sumfromAsOdd[i]=new Node();
            if(i<n-1){
                sumfromAsOdd[i].odd+=sumfromAsOdd[i+1].even+a[i];
                sumfromAsOdd[i].even=sumfromAsOdd[i+1].odd;
            }else{
                sumfromAsOdd[i].odd=a[i];
            }
        }
        Node[] sumFromAsEven = new Node[n];
        for(int i=n-1;i>=0;i--){
            sumFromAsEven[i]=new Node();
            if(i<n-1){
                sumFromAsEven[i].even+=sumFromAsEven[i+1].odd+a[i];
                sumFromAsEven[i].odd=sumFromAsEven[i+1].even;
            }else{
                sumFromAsEven[i].even=a[i];
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            int even=0,odd=0;
            if(i-1>=0) {
                even+= sumtill[i - 1].even;
                odd+=sumtill[i-1].odd;
            }
            if(i+1<n){
                if((i+1)%2==0){
                    even+=sumFromAsEven[i+1].even;
                    odd+=sumFromAsEven[i+1].odd;
                }else{
                    even+=sumfromAsOdd[i+1].even;
                    odd+=sumfromAsOdd[i+1].odd;
                }
            }
            if(even==odd)
                cnt++;
        }
        System.out.println(cnt);
    }
    private static class Node{
        int odd;
        int even;
    }
}
