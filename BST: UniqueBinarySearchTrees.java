public class Solution {
    public int numTrees(int n) {
        int []cache = new int[n+1];
        return dp_recursive(n, cache);
    }
    
    public int recursion(int n){
        if(n<=1) return 1;
        
        int count = 0;
        for(int i = 1; i<=n; i++){
            count += recursion(i-1)*recursion(n-i); 
        }
        
        return count;
    }
    
    public int dp_recursive(int n, int[]cache){
        if(cache[n]!=0) return cache[n];
        
        if(n==0 || n==1){
            cache[n] = 1;
            return 1;
        }
        int count = 0;
        for(int i = 1; i<=n; i++){
            count += dp_recursive(i-1, cache) * dp_recursive(n-i, cache);
        }
        cache[n] = count;
        return count;
    }
    
    public int dp_iterative(int n){
        int []cache =  new int[n+1];
        cache[0] = 1;
        cache[1] = 1;
        
        for(int i = 2; i <= n; i++){
            int count = 0;
            for(int j = 1; j<=i; j++){
                count += cache[j-1] * cache[j-i];
            }
            cache[i] = count;
        }
        return cache[n];
    }
}
