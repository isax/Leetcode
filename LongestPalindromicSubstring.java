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
    
    /*
     * Running Time: O(n^2) Space: O(1)
     */
    
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i<s.length(); i++){
            String odd = expand(s, i, i); // ....i....
            String even  = expand(s, i, i+1); // ....i i+1....
            
            String better = odd.length() > even.length()?odd: even;
            res = better.length()>res.length()? better:res;
        }
        return res;
    }
    
    public String expand(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}
