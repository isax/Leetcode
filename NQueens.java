public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[]result = new int[n];
        
        helper(0, n, result, list);
        ArrayList<String[]> res = new ArrayList<String[]>();
        
        for(int[]array: list){
        	String []str = new String[n];
        	for(int i = 0; i<n; i++){
        		int col = array[i];
        		char[]charArr = generateChar(n);
        		charArr[col] = 'Q';
        		String strRow = String.copyValueOf(charArr);
        		str[i] = strRow;
        	}
        	res.add(str);
        }
        
        return res;	
    }
    
  public static char[] generateChar(int n){
		char[]array = new char[n];
		for(int i = 0; i<n; i++){
			array[i] = '.';
		}
		return array;
	}
	
	public void helper(int row, int size, int[]result, ArrayList<int[]>list){
		if(row==size){
			list.add(result.clone());
		}else{
			for(int col=0; col<size; col++){	
				if(checkValid(row, col, result)){
					result[row] = col;
					helper(row+1, size, result, list);
				}	
			}
		}
	}
	
	public static boolean checkValid(int row, int col, int[]result){
		for(int i = 0;i<row; i++){
			int pre_col = result[i];
			if(pre_col==col) return false;
			int checkRow = Math.abs(row-i);
			
			if(checkRow == Math.abs(col-pre_col)){
				return false;
			}
		}
		return true;
	}
}
