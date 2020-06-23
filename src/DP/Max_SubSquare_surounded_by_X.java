package DP;

import java.util.Scanner;

public class Max_SubSquare_surounded_by_X {
    static class Pair{
        int ver, hor;
        Pair(){
            ver=0;
            hor=0;
        }
    }

    /**
     * for EASE I'm replacing X with 1 in the question
     */
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int ar[][] = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                ar[i][j] = s.nextInt();
            }
        }
        Pair ans[][] = new Pair[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j] = new Pair();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ar[i][j] == 1){
                    if(i==0&&j==0){
                        ans[i][j].hor = 1;
                        ans[i][j].ver = 1;
                    }else if(i==0){
                        ans[i][j].hor = 1+ ans[i][j-1].hor;
                        ans[i][j].ver = 1;
                    }else if(j==0){
                        ans[i][j].hor = 1;
                        ans[i][j].ver = 1+ans[i-1][j].ver;
                    }else{
                        ans[i][j].hor = ans[i][j-1].hor+1;
                        ans[i][j].ver = ans[i-1][j].ver+1;
                    }
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(ans[i][j].hor+","+ans[i][j].ver+" ");
            }
            System.out.println();
        }
        int max = 1;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(ans[i][j].hor<=1||ans[i][j].ver<=1){
                    continue;
                }
                int k = Math.min(ans[i][j].hor, ans[i][j].ver);
                for(;k>1;k--){
                    if(ans[i][j-k+1].ver>=k&&ans[i-k+1][j].hor>=k){
                        break;
                    }
                }
                max = Math.max(max, k);
            }
        }
        System.out.println(max);
    }
}
