public class UniquePathII {
    public int [][] map = new int[101][101];
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0; // obstacle in finish pt
        for(int i = 0; i<101; i++){
            for (int j = 0; j<101; j++){
                map[i][j] = -1;
            }
        }
        int m = obstacleGrid.length - 1;
        int n = obstacleGrid[0].length - 1;
        return pathsHelper(m,n,obstacleGrid);
    }
    
    /*
     * DP, Top-down approach, memoization
     */
    public int pathsHelper(int m, int n, int[][] obstacleGrid){
        if(m<0||n<0||obstacleGrid[m][n]==1) return 0;
        if(m==0&&n==0) return 1;
        
        if(map[m][n]==-1)
           map[m][n] = pathsHelper(m-1, n, obstacleGrid) + pathsHelper(m, n-1, obstacleGrid);
            
        return map[m][n];
    }
    
    /*
     * DP, Bottom-up approach
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int [][] map = new int[m][n];
        map[0][0] = 1;
        
        for(int i = 1; i<m; i++){ //start from 1, not 0
            if(obstacleGrid[i][0]==0) map[i][0] = map[i-1][0]; // easy to make mistake, not just = 1 anymore
            else map[i][0] = 0;
        }
        for(int j = 1; j<n; j++){
            if(obstacleGrid[0][j]==0) map[0][j] = map[0][j-1];
            else map[0][j] = 0;
        }
        
        for(int i = 1; i<m;i++){
            for(int j = 1; j<n;j++){
                if(obstacleGrid[i][j]==0) map[i][j] = map[i-1][j]+map[i][j-1];
                else map[i][j] = 0;
            }
        }
        
        return map[m-1][n-1];
    }
}
