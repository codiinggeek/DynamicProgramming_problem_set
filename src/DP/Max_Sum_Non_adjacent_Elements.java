package DP;

import java.util.Scanner;

public class Max_Sum_Non_adjacent_Elements {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = s.nextInt();
        }
        int in = ar[0];
        int ex = 0;
        for(int i=1;i<n;i++){
            int t = in;
            in = Math.max(ex+ar[i], in);
            ex = t;
        }
        System.out.println(Math.max(in, ex));
    }
}
