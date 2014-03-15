public class WordBreak {

    /*
     * dp
     */
    public boolean wordBreak(String s, Set<String> dict) {

        int length = s.length();
        boolean []dp = new boolean[length+1];
        dp[0] = true;
        
        for(int i = 1; i<length+1; i++){
            String sub = s.substring(0, i);
            for(int k = 0; k<=i-1; k++){
                if(dp[k] && dict.contains(sub.substring(k, i))){
                    dp[i]  = true;
                    break;
                }
            
            }
        }
        return dp[length];
    }

    /*
     * dfs
     */
    public boolean wordBreak(String s, Set<String> dict) {
        return canBuildWord(s, dict);
        
        int length = s.length();
        boolean []dp = new boolean[length+1];
        dp[0] = true;
        
        for(int i = 1; i<length+1; i++){
            String sub = s.substring(0, i-1);
            if(dict.contains(sub)){
                dp[i] = true;
            }else{
                for(int k = 0; k<i; k++){
                    if(dp[k])
                }
            }
        }
    }
    
    
}
