public class Solution {
    public int totalNQueens(int n) {
        int []result = new int[n];
        return helper(0, n, result);
    }
    
    public int helper(int row, int n, int []result){
        if(row==n){
            return 1;
        }
        
        int sum = 0;    
        for(int col = 0; col<n; col++){
            if(checkValid(row, col, result)){
                result[row] = col;
                sum += helper(row+1, n, result);
            }
        }
        return sum;
    }
    
    //check col and diagonal
    public boolean checkValid(int row, int col, int []result){
        for(int i = 0; i<row; i++){
            if(result[i]==col) return false;
            if(Math.abs(col-result[i])==Math.abs(row-i)) return false;
        }
        return true;
    }
}
