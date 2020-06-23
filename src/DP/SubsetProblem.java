package DP;

/**
 * check a particular value could be formed using sub set of numbers in an array
 * int total = 11;
 * int ar[] = {2,3,7,8,10};
 */
public class SubsetProblem {
    public static void main(String[] args){
        int total = 11;
        int ar[] = {2,3,7,8,10};
        boolean arr[][] = new boolean[5][12];
        for(int i=0;i<5;i++){
            arr[i][0] = true;
        }
        for(int i=0;i<5;i++){
            for(int j=1;j<12;j++){
                int a = ar[i];
                if(j<a){
                    if(i==0)
                        arr[i][j] = false;
                    else
                        arr[i][j] = arr[i-1][j];
                }else{
                    if(i==0){
                        if(j==a){
                            arr[i][j]=true;
                        }
                    }else{
                        if(arr[i-1][j-a]){
                            arr[i][j] = true;
                        }
                    }
                }
            }
        }
        int y=-1;
        for(int i=0;i<5;i++){
            if(arr[i][total]){
                y=1;
                break;
            }
        }
        if(y==1){
            System.out.println("found");
        }else{
            System.out.println("not found");
        }
    }
}
