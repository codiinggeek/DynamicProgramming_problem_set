package DP;

/**
 * for understanding:
 * https://www.youtube.com/watch?v=Fi5INvcmDos
 */
public class Longest_palindromic_Substring_DP {
    public static void main(String[] args){
        String s = "abaabc";
        int len = s.length();
        boolean ar[][] = new boolean[len+1][len+1];
        String palin = ""+s.charAt(0);
        int longest = 1;
        for(int i=0;i<len;i++){
            ar[i][i] = true;
        }
        for(int i=0;i<len-1;i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            if(ch1==ch2){
                ar[i][i+1] = true;
                longest = 2;
                palin = s.substring(i,i+2);
            }
        }
        int j=0;
        for(int k=2;k<len;k++) {
            for (int i = 0; i < len-k; i++) {
                j = i + k;
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                if (ch1 == ch2) {
                    if (ar[i + 1][j - 1]) {
                        int l = j - i + 1;
                        if (l > longest) {
                            longest = l;
                            palin = s.substring(i, j + 1);
                        }
                        ar[i][j] = true;
                    }
                }
            }
        }
        System.out.println(palin);
        System.out.println(longest);

    }
}
