public class UniquePath {

    public int [][] map = new int[101][101];
    /*
     * DP Top-down tracking 
     */
    public int uniquePaths(int m, int n) {
        if(m==1&&n==1) return 1;
        if(m<1||n<1) return 0;
        
        if(map[m][n]==0) 
            map[m][n] = uniquePaths(m-1, n) + uniquePaths(m, n-1);
            
        return map[m][n];
    }
    
    /*
     * DP Bottom-up tracking 
     */
    public int uniquePaths2(int m, int n) {
        int [][] map = new int[m][n];
        map[0][0] = 1;
        for(int i = 0; i<m; i++){
            map[i][0] = 1;
        }
        for(int j = 0; j<n; j++){
            map[0][j] = 1;
        }
        
        for(int i = 1; i<m;i++){
            for(int j = 1; j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
}
