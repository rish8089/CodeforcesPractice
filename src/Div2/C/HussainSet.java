package Div2.C;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class FastIO {
    static BufferedInputStream in = new BufferedInputStream(System.in);

    static int readInt() {
        int no = 0;
        boolean minus = false;
        try {
            int a = in.read();
            while (a == 32 || a == 10) //10 is newline & 32 is ASCII for space
                a = in.read();
            if (a == '-') {
                minus = true;
                a = in.read();
            }
            while (a != 10 && a != 32 && a != -1) {
                no = no * 10 + (a - '0');
                a = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return minus ? -no : no;
    }

    static long readLong() {
        long no = 0;
        boolean minus = false;
        try {
            int a = in.read();
            while (a == 32 || a == 10) //10 is newline & 32 is ASCII for space
                a = in.read();
            if (a == '-') {
                minus = true;
                a = in.read();
            }
            while (a != 10 && a != 32 && a != -1) {
                no = no * 10 + (a - '0');
                a = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return minus ? -no : no;
    }

    static String read() {
        StringBuilder str = new StringBuilder();
        try {
            int a = in.read();
            while (a == 32)
                a = in.read();
            while (a != 10 && a != 32 && a != -1) {
                str.append((char) a);
                a = in.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.toString();
    }
}

public class HussainSet {
    public static void main(String[] args) throws IOException {
        int n = FastIO.readInt();
        int m = FastIO.readInt();
        List<Long> answers = new ArrayList<>();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(FastIO.readLong());
        Collections.sort(list);
//        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
//        for(int i=0;i<n;i++)
//            pq.add(Long.parseLong(str[i]));
//        while(!pq.isEmpty()){
//            long max=pq.poll();
//            answers.add(max);
//            max/=2;
//            if(max>0)
//                pq.add(max);
//        }
        Queue<Long> queue = new ArrayDeque<>(n*63);
        int currListIdx = list.size() - 2;
        answers.add(list.get(list.size() - 1));
        queue.add(list.get(list.size() - 1) / 2);
        while (!queue.isEmpty()) {
            if (currListIdx >= 0) {
                if (list.get(currListIdx) > queue.peek()) {
                    long elem = list.get(currListIdx);
                    answers.add(elem);
                    if (elem / 2 > 0) {
                        queue.add(elem / 2);
                    }
                    currListIdx--;
                } else {
                    long elem = queue.poll();
                    answers.add(elem);
                    if (elem / 2 > 0) {
                        queue.add(elem / 2);
                    }
                }
            } else {
                long elem = queue.poll();
                answers.add(elem);
                if (elem / 2 > 0) {
                    queue.add(elem / 2);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (m > 0) {
            int q = FastIO.readInt();
            ans.append(answers.get(q - 1)).append("\n");
            m--;
        }
        System.out.println(ans);
    }
}
