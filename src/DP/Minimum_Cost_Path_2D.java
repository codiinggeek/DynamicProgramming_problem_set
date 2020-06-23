package DP;

import java.util.Scanner;

public class Minimum_Cost_Path_2D {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int c = s.nextInt();
        int ar[][] = new int[r][c];
        int ans[][] = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ar[i][j] = s.nextInt();
            }
        }
        System.out.println();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0&&j==0){
                    ans[i][j] = ar[i][j];
                }else if(i==0){
                    ans[i][j] = ar[i][j] + ans[i][j-1];
                }else if(j==0){
                    ans[i][j] = ar[i][j] + ans[i-1][j];
                }else {
                    int a = ar[i][j] + ans[i-1][j];
                    int b = ar[i][j] + ans[i][j-1];
                    ans[i][j] = Math.min(a, b);
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Ans: "+ans[r-1][c-1]);
    }
}
