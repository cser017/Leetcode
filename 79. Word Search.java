class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0){
            return false;
        }
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++){
                if(bfs(board, word, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean bfs(char[][] board, String word, int i, int j) {
        if(word.length() == 0){ // all characters found
            return true;
        }
        // reach border
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        // wrong character
        if(word.charAt(0) != board[i][j]){
            return false;
        }
        // mark visited
        char tmp = board[i][j];
        board[i][j] = '$';
        
        boolean res = 
            bfs(board, word.substring(1,word.length()), i + 1, j) || 
            bfs(board, word.substring(1,word.length()), i - 1, j) || 
            bfs(board, word.substring(1,word.length()), i, j + 1) ||
            bfs(board, word.substring(1,word.length()), i, j - 1);
        
        board[i][j] = tmp;
        return res;
    }
}