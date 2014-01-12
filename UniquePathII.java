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
     * DP, Top-down approach
     */
    public int pathsHelper(int m, int n, int[][] obstacleGrid){
        if(m<0||n<0||obstacleGrid[m][n]==1) return 0;
        if(m==0&&n==0) return 1;
        
        if(map[m][n]==-1)
           map[m][n] = pathsHelper(m-1, n, obstacleGrid) + pathsHelper(m, n-1, obstacleGrid);
            
        return map[m][n];
    }
}
