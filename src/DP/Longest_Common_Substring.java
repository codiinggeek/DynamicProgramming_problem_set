package DP;

public class Longest_Common_Substring {
    public static void main(String[] args){
        String a = "abcdaffff";
        String b = "zbcdffff";
        int l1 = a.length();
        int l2 = b.length();
        int ar[][] = new int[l1][l2];
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                char ch1 = a.charAt(i);
                char ch2 = b.charAt(j);
                if(ch1!=ch2){
                    ar[i][j] = 0;
                }else{
                    if(i!=0){
                        ar[i][j] = 1+ar[i-1][j-1];
                    }else{
                        ar[i][j] = 1;
                    }
                }
            }
        }
        int ii = 0,jj=0;
        int temp = Integer.MIN_VALUE;
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                if(temp<ar[i][j]){
                    temp = ar[i][j];
                    ii = i;
                    jj = j;
                }
            }
        }
        if(temp==0){
            System.out.println("Nothing Common Found");
        }else{
            String common = "";
            while(ii>=0&&jj>=0&&ar[ii][jj]!=0){
                common = a.charAt(ii)+common;
                ii--;
                jj--;
            }
            System.out.println(common);
        }
    }
}
