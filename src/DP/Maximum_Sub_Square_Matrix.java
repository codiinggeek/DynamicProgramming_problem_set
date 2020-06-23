package DP;

import java.util.Scanner;

public class Maximum_Sub_Square_Matrix {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int ar[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ar[i][j] = s.nextInt();
            }
        }
        int count = 0;
        int ans[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ar[i][j]==1){
                    if(i==0||j==0){
                        ans[i][j] = 1;
                        count = Math.max(count, ans[i][j]);
                    }else{
                        ans[i][j] = 1+Math.max(ans[i][j-1], Math.max(ans[i-1][j],ans[i-1][j-1]));
                        count = Math.max(count, ans[i][j]);
                    }
                }
            }
        }
        System.out.println(count);

    }
}
