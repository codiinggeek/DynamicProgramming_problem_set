package DP;

/**
 * Classical Dp problem
 * 2 strings:
 * abcdaf
 * acbcf
 * find the longest common subsequence ans: abcf
 */
public class Longest_Common_Subsequence {
    public static void main(String[] args){
        String s1 = "abcdaf";
        String s2 = "acbcf";
        int l1 = s1.length();
        int l2 = s2.length();
        int ar[][] = new int[l1+1][l2+1];
        for(int i=1;i<l1+1;i++){
            for(int j=1;j<l2+1;j++){
                char ch1 = s1.charAt(i-1);
                char ch2 = s2.charAt(j-1);
                if(ch1==ch2){
                    ar[i][j] = ar[i-1][j-1]+1;
                }else{
                    ar[i][j] = Math.max(ar[i-1][j], ar[i][j-1]);
                }
            }
        }
        int ans = ar[l1][l2];
        String ss = "";
        for(int i=l1;i>=1;){
            for(int j=l2;j>=1;){
                int a = ar[i][j];
                if(a>ar[i-1][j]&&a>ar[i][j-1]){
                    ss = s1.charAt(i-1)+ss;
                    i--;
                    j--;
                }else if(a>ar[i][j-1]&&a==ar[i-1][j]){
                    i--;
                }else if((a==ar[i][j-1]&&a==ar[i-1][j])||(a==ar[i][j-1]&&a>ar[i-1][j])){
                    j--;
                }
            }
        }
        System.out.println(ss);
        System.out.println(ans);
    }
}
