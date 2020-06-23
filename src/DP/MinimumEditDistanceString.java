package DP;

/**
 * For better understanding LINK: https://www.youtube.com/watch?v=MiqoA-yF-0M
 * or
 * Tushar Roy video
 * https://www.youtube.com/watch?v=We3YDTzNXEk&t=332s
 *
 * with 2 strings given calculate the minimum distance to convert one string to another
 * We will check for every possible substring combination for conversion from the start
 * Situation 1: if characters are same don't change the distance calculated till now
 * Situation 2: if characters are different we need to take minimum of the 3 possibilities
 * insert delete or replace.
 *
 *      Replace Insert
 *      Delete  You are here
 */
public class MinimumEditDistanceString {
    public static void main(String[] args){
        String s1 = "abcdef";
        String s2 = "azced";
        int l1 = s1.length();
        int l2 = s2.length();
        int ar[][] = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++){
            ar[i][0] = i;
        }
        for(int i=0;i<=l2;i++){
            ar[0][i] = i;
        }
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                char ch1 = s1.charAt(i-1);
                char ch2 = s2.charAt(j-1);
                if(ch1==ch2){
                    ar[i][j] = ar[i-1][j-1];
                }else{
                    ar[i][j] = 1+Math.min(ar[i-1][j], Math.min(ar[i-1][j-1], ar[i][j-1]));
                }
            }
        }
        System.out.println(ar[l1][l2]);
    }
}
