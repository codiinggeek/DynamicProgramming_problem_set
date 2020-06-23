package DP;

public class Longest_palindromic_subsequence {
    public static void main(String[] args){
        String s = "agbdba";
        int l = s.length();
        int ar[][] = new int[l][l];
        for(int i=0;i<l;i++){
            ar[i][i] = 1;
        }
        for(int i=0;i<l-1;i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            if(ch1==ch2){
                ar[i][i+1] = 2;
            }else{
                ar[i][i+1] = 1;
            }
        }
        int j=0;
        for(int k=2;k<l;k++){
            for(int i=0;i<l-k;i++){
                j = i+k;
                if(s.charAt(i)==s.charAt(j)){
                    ar[i][j] = ar[i+1][j-1]+2;
                }else{
                    ar[i][j] = Math.max(ar[i+1][j], ar[i][j-1]);
                }
            }
        }
        for(int i=0;i<l;i++){
            for(j=0;j<l;j++){
                System.out.print(ar[i][j]);
            }
            System.out.println();
        }
        System.out.println(ar[0][l-1]);
    }
}
