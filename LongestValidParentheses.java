public class LongestValidParentheses {
    
    public int longestValidParenthesesDP(String s) {
        int length = s.length();
        if(length==0) return 0;
        
        int[]dp = new int[length];
        dp[length-1] = 0;
        int maxLength = 0;
        
        for(int i = length-2; i>=0; i--){
            
            if(s.charAt(i)==')') dp[i] = 0;
            
            else{
                int j = i + 1 + dp[i+1];
                if(j<length && s.charAt(j) ==')') { //((....))
                    dp[i] = dp[i+1] + 2;
                    if(j+1<length){ // ((....))()()
                        dp[i] += dp[j+1];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
    
    /*
     * Like max Subarray sum 
     */
    public int longestValidParentheses(String s) {
        int length = s.length();
        if(length==0) return 0;
        
        Stack<Integer>st = new Stack<Integer>();
        int last = -1; // Attention!!
        int maxLength = 0;
        for(int i = 0; i<length; i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else{ //')'
                if(st.isEmpty()){
                    last = i;
                }else{
                    st.pop();
                    if(st.isEmpty()){
                        maxLength = Math.max(maxLength, i-last);//   ) () ()
                    }else{
                        maxLength = Math.max(maxLength, i-st.peek());//   ) () () ( () ()
                    }
                }
            }
        }
        return maxLength;
    }
    
    /*
     * Tried two dimensional dp but failed, wrong logic
    int [][]dp;
    public int helperIncorrect(String s, int i, int j){
        if(i<=j || i<0 ||j>s.length()-1) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int a = 0;
        if(s.charAt(j)=='(' && s.charAt(i)==')') a = helper(s, i-1, j+1) + 1;
        else a = helper(s, i-1, j+1);
        
        int b = helper(s, i-1, j);
        int c = helper(s, i, j+1);
        
        dp[i][j] =Math.max( Math.max(a, b), c);
        return dp[i][j];
    }
    public int longestValidParenthesesIncorrect(String s) {
        int length = s.length();
        if(length==0) return 0;
        dp = new int[length][length];
        for(int i = 0; i<length; i++){
            for(int j = 0; j<length; j++){
                dp[i][j] = -1;
            }
        }
        return helper(s, length-1, 0);
    }*/
}
