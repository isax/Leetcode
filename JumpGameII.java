public class JumpGameII {
    
    /*
     * DP
     */
    public int jump(int[] A) {
        
        int length = A.length;
        int []dp = new int[length];
        dp[0] = 0;
        
        for(int i = 1; i<length; i++){
            for(int j = 0; j<i; j++){
                if(j+A[j]>=i) {
                    dp[i] = dp[j]+1;
                    break;
                }
            }
        }
        return dp[length-1];
    }
    
    /* Wrong logic using DP: should have scanned from 0 to i-1 
    public int jump(int[] A) {
        int length = A.length;
        int []dp = new int[length];
        dp[0] = 0;
        
        for(int i = 1; i<length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = i-1; j>=0; j--){
                if(A[j]<i-j) break;
                else{
                    min = Math.min(dp[j]+1, min);
                }
            }
            dp[i] = min;
        }
        return dp[length-1];
    }*/
}
