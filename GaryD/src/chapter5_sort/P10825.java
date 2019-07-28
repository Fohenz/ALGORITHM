package chapter5_sort;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
import java.util.Arrays;
import java.util.Scanner;

class Person implements Comparable<Person>{
    String name;
    int kor;
    int eng;
    int math;

    Person(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    @Override
    public int compareTo(Person that) {
        if(this.kor > that.kor) {
            return -1;
        } else if(this.kor == that.kor) {
            if(this.eng < that.eng) {
                return -1;
            } else if(this.eng == that.eng) {
                if(this.math > that.math) {
                    return -1;
                } else if(this.math == that.math) {
                    return this.name.compareTo(that.name);
                }
            }
        }
        return 1;
    }
}

public class P10825 {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Person[] pAry = new Person[n];
        for(int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            pAry[i] = new Person(s[0], 
                    Integer.valueOf(s[1]),
                    Integer.valueOf(s[2]),
                    Integer.valueOf(s[3]));
        }
        Arrays.sort(pAry);
        for(Person p : pAry) {
            sb.append(p.name + "\n");
        }
        System.out.println(sb);
    }
}