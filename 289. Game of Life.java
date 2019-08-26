// in place
//
// die -> die => 0
// die -> live => 2
// live -> live => 1
// live -> die => -1

class Solution {
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                int cnt = cntLiveNeighbor(board, i, j);
                if(board[i][j] == 1){
                    if(cnt < 2 || cnt > 3){
                        board[i][j] = -1;
                    }
                } else if(cnt == 3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(board[i][j] > 0){  
                    board[i][j] = 1;       
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int cntLiveNeighbor(int[][] board, int i, int j) {
        int res = 0;  
        if(i > 0){
            res += Math.abs(board[i - 1][j]) == 1 ? 1:0;
            if(j > 0){
                res += Math.abs(board[i - 1][j - 1]) == 1 ? 1:0;            
            }   
            if(j < board[0].length - 1){        
                res += Math.abs(board[i - 1][j + 1]) == 1 ? 1:0;          
            } 
        }
        if(i < board.length - 1){
            res += Math.abs(board[i + 1][j]) == 1 ? 1:0;
            if(j < board[0].length - 1){        
                res += Math.abs(board[i + 1][j + 1]) == 1 ? 1:0;
            } 
            if(j > 0){
                res += Math.abs(board[i + 1][j - 1]) == 1 ? 1:0;
            }
        }
        if(j > 0){
            res += Math.abs(board[i][j - 1]) == 1 ? 1:0;
            }
        if(j < board[0].length - 1){        
            res += Math.abs(board[i][j + 1]) == 1 ? 1:0;
            } 
        return res;
    }
}