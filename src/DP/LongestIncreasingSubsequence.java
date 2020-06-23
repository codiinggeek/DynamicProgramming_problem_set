package DP;

import java.util.*;
public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int ar[] = {3,4,-1,0,6,2,3};
        int ans[] = new int[ar.length];
        int i=1,j=0;
        Arrays.fill(ans, 1);
        while(j!=(ar.length-1)&&i!=(ar.length)){
            if(ar[j]<ar[i]){
                ans[i] = 1+ans[j];
            }
            j++;
            if(i==j){
                i = i+1;
                j=0;
            }
        }
        int max= -1;
        for(i=0;i<ar.length;i++){
            max = Math.max(max, ans[i]);
        }
        System.out.println(max);
    }
}