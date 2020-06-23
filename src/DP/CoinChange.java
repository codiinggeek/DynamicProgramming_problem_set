package DP;

/**
 * find minimum count of coins needed to make the total
 */
public class CoinChange {
    public static void main(String[] args){
        int total = 11;
        int coins[] = {1,5,6,8};
        int ar[][] = new int[4][12];
        for(int i=0;i<4;i++){
            for(int j=1;j<12;j++){
                int a = coins[i];
                if(j<a){
                    if(i!=0){
                        ar[i][j] = ar[i-1][j];
                    }
                }else{
                    if(i!=0) {
                        int b = 1 + ar[i][j - a];
                        ar[i][j] = Math.min(ar[i - 1][j], b);
                    }else{
                        ar[i][j] = j;
                    }
                }
            }
        }
        /**
         * Coins included
         */
        int i=3;
        int j=11;
        int ans[] = new int[12];
        int m=0;
        while(j!=0){
            if(i!=0){
                if(ar[i][j]==ar[i-1][j]){
                    i--;
                }else{
                    ans[m] = coins[i];
                    m++;
                    j -= coins[i];
                }
            }else{
                ans[m] = coins[i];
                m++;
                j -= coins[i];
            }
        }
        for(i=0;i<m;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
        System.out.println(ar[3][11]);
    }
}
