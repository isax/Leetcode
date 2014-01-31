public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix==null) return;
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean []row = new boolean[m];
        boolean []col = new boolean[n];
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j]==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(row[i]||col[j]) matrix[i][j] = 0;
            }
        }
    }
    
    /*
     * Space: O(1)
     */
    public void setZeroes(int[][] matrix) {
        if(matrix==null) return;
        int row = matrix.length;
        int col = matrix[0].length;
        
        boolean fstrow = false;
        boolean fstcol = false;
        
        for(int i = 0; i<col; i++){
            if(matrix[0][i]==0){
                fstrow = true;
                break;
            }
        }
        
        for(int i = 0; i<row; i++){
            if(matrix[i][0]==0){
                fstcol = true;
                break;
            }
        }
        
        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        // set zeroes except the first row and column
        // Notice: cannot start from 0, otherwise ruin the flags
        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                if(matrix[0][j]==0||matrix[i][0]==0) matrix[i][j] = 0;
            }
        }
        
        if(fstrow){
            for(int i = 0; i<col; i++){
                matrix[0][i] = 0;
            }
        }
        
        if(fstcol){
            for(int i = 0; i<row; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
