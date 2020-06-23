package DP;

/**
 * 0/1 Knapsack DP classical problem solution
 * using 2-D matrix to find the Solution
 * Read GFG for better explanation of question
 * Tushar Roy video for video explanation
 */

public class KnapsackDP {
    public static void main(String[] args){
        int totalWeight = 7;
        int w[] = {1,3,4,5};
        int val[] = {1,4,5,7};

        int ans[][] = new int[4][8];
        for(int i = 0;i<w.length;i++){
            for(int j=1;j<=totalWeight;j++){
                int a = w[i];
                if(j<a){
                    if(i!=0)
                        ans[i][j] = ans[i-1][j];
                }else {
                    if(i!=0){
                        int aa = val[i] + ans[i-1][j-a];
                        ans[i][j] = Math.max(aa, ans[i-1][j]);
                    }else{
                        ans[i][j] = val[i];
                    }
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<=7;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Max sum:"+ans[3][7]);
    }
}
