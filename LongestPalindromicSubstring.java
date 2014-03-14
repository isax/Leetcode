public class LongestPalindromicSubstring  {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean [][]dp = new boolean[length][length];
        int maxLength = Integer.MIN_VALUE;
        int longestBegin = 0;
        
        for(int i = length-1; i>=0; i--){
            for(int j = i; j<length; j++){
                if(i==j) dp[i][j] = true;
                else if(j==i+1){
                    dp[i][j] = (s.charAt(i)==s.charAt(j));
                }else{
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i)==s.charAt(j));
                }
                
                if(dp[i][j]){
                    if(j-i+1>maxLength){
                        maxLength = j-i+1;
                        longestBegin = i;
                    }
                }
            }
        }
        return s.substring(longestBegin, longestBegin+maxLength);
    }
}
