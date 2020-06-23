package DP;

public class CuttingRodToMaximizeProfit {
    public static void main(String []args){
        int l = 5;
        int len[] = {1,2,3,4};
        int profit[] = {2,5,7,8};
        int ar[][] = new int[4][6];
        for(int i=0;i<4;i++){
            for(int j=1;j<6;j++){
                int a = len[i];
                if(a>j){
                    if(i==0){
                        ar[i][j] = 0;
                    }else{
                        ar[i][j] = ar[i-1][j];
                    }
                }else{
                    if(i==0)
                        ar[i][j] = profit[i]+ar[i][j-a];
                    else{
                        int aa = profit[i]+ar[i][j-a];
                        ar[i][j] = Math.max(aa, ar[i-1][j]);
                    }
                }
            }
        }
        System.out.println(ar[3][5]);
    }
}
