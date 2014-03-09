public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(word.length()==0) return true;
        
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board, visited, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean helper(char[][]board, boolean[][]visited, String word, int index, int x, int y){
        if(board[x][y]!=word.charAt(index)) return false;
        
        if(index==word.length()-1) return true;
        
        int row = board.length;
        int col = board[0].length;
        
        // set this point to visited
        visited[x][y] = true;
        
        //up
        if(x!=0 && !visited[x-1][y]){
            if(helper(board, visited, word, index+1, x-1, y)) return true;
        }
        
        //down
        if(x!=row-1 && !visited[x+1][y]){
            if(helper(board, visited, word, index+1, x+1, y)) return true;
        }
        
        //left
        if(y!=0 && !visited[x][y-1]){
            if(helper(board, visited, word, index+1, x, y-1)) return true;
        }
        
        //right
        if(y!=col-1 && !visited[x][y+1]){
            if(helper(board, visited, word, index+1, x, y+1)) return true;
        }
        
        // This path doesnot work, need to set the point back to unvisited
        visited[x][y] = false;
        
        return false;
    }
}

