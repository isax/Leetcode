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
}
