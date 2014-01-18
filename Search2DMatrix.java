public class Search2DMatrix {

	/*
	 * O(M+N)
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		
		int row = 0;
		int col = matrix[0].length - 1;
		
		while(row<matrix.length&&col>=0){
			if(matrix[row][col]==target) return true;
			else if(matrix[row][col] > target) col--;
			else row++;
		}	
		return false;	
	}

    /*
     * Another implementation on Leetcode. The matrix can be viewed as a one-dimensional sorted array. 
     * Link: http://oj.leetcode.com/discuss/249/search-a-2d-matrix
     * O(log(MN)) = O(logM + logN)
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int s = 0, e = rows* cols - 1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(matrix[m/cols][m%cols]==target)
            return true;
            else if(matrix[m/cols][m%cols]>target){
                e = m -1;
            }else{
                s = m + 1;
            }
        }
        return false;
    }
    
    
   
}
