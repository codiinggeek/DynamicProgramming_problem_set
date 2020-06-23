package DP;

import java.util.Scanner;

public class Max_Increasing_Sum_Subsequence {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ar[] = new int[n];
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = s.nextInt();
            ans[i] = ar[i];
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(ar[j]>=ar[i])
                    continue;
                ans[i] = Math.max(ans[i], ar[i]+ans[j]);
                max = Math.max(ans[i],max);
            }
        }
        System.out.println(max);
    }
}
