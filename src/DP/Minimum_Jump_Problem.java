package DP;

import java.util.Scanner;

public class Minimum_Jump_Problem {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ar[] = new int[n+1];
        for(int i=0;i<=n;i++)
        {
            ar[i] = s.nextInt();
        }
        int jumps[] = new int[n+1];
        int pos[] = new int[n+1];
        for(int i=1;i<=n;i++){
            jumps[i] = Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                int a = ar[j];
                if(a+j<i)
                    continue;
                else{
                    int b = jumps[j]+1;
                    if(b<jumps[i]){
                        jumps[i] = b;
                        pos[i] = j;
                    }
                }
            }
        }
        System.out.println(jumps[n]+" "+pos[n]);
    }
}
