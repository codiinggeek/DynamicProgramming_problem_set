package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=o_AJ3VWQMzA
 * Watch Gaurav sen video for explanation
 */
public class EggDroppingProblem {
    public static void main(String[] args){
        int n = 8;
        int e = 4;
        int ar[][] = new int[9][5];
        for(int i=0;i<=n;i++){
            ar[i][1] = i;
        }
        for(int i=1;i<5;i++){
            ar[1][i] = 1;
        }
        for(int i=2;i<=n;i++){
            for(int j=2;j<=e;j++){
                ar[i][j] = Integer.MAX_VALUE;
                for(int x = 1;x<i;x++){
                    int broke = ar[x-1][j-1];
                    int notbroke = ar[i-x][j];
                    int temp = Math.max(broke, notbroke)+1;
                    if(temp<ar[i][j]){
                        ar[i][j] = temp;
                    }
                }
            }
        }
        for(int a[]: ar){
            System.out.println(Arrays.toString(a));
        }
        System.out.println(ar[n][e]);
    }
}
