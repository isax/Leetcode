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
    
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) 
            return false;
        int left = 0; int right = matrix.length-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            if(target==matrix[mid][0]) return true;
            else if(target<matrix[mid][0]) right = mid-1;
            else left = mid+1;
        }
        if(right==-1) return false;
        int row = right;
        
        left = 0; right = matrix[0].length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(target==matrix[row][mid]) return true;
            else if(target<matrix[row][mid]) right = mid-1;
            else left = mid+1;
        }
        return false;
    }
    
    
   
}
