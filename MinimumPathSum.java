public class MinimumPathSum {
    
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int [][] minPath = new int[row][col];
        minPath[0][0] = grid[0][0];
        
        //first row
        for(int i = 1; i<col; i++){ // i starting from 1!!!!!
            minPath[0][i] = minPath[0][i-1]+grid[0][i];
        }
        //first column
        for(int j = 1; j<row; j++){ //j starting from 1!!!!
            minPath[j][0] = minPath[j-1][0] + grid[j][0];
        }
        
        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                minPath[i][j] = Math.min(minPath[i-1][j]+grid[i][j], minPath[i][j-1]+grid[i][j]);
            }
        }
        
        return minPath[row-1][col-1];
    }
    
}
