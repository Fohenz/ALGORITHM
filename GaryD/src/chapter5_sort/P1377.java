package chapter5_sort;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
import java.util.*;
import java.io.*;
 
class P1377 {
    static int stoi(String s) { return Integer.parseInt(s);}
 
    static class Pair implements Comparable<Pair> {
        int index;
        long value;
 
        public Pair(int index, long value) {
            this.index = index;
            this.value = value;
        }
 
        public int compareTo(Pair o) {
            if(this.value - o.value == 0) 
                return this.index - o.index;
       
            return (int) (this.value - o.value);
        }
 
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int n = stoi(br.readLine());
        int max = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
 
        for(int i=0; i<n; i++) {
            pq.add(new Pair(i, stoi(br.readLine())));
        }
 
        int idx = 0;
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
 
            if(max < pair.index - idx)
                max = pair.index - idx;
 
            idx++;
        }
 
        System.out.println(max+1);
    }
}

