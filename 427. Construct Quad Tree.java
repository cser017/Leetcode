/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }
    
    public Node build(int[][] grid, int row1, int row2, int col1, int col2) {
        if(row1 > row2 || col1 > col2){
            return null;
        }
        if(isLeaf(grid, row1, row2, col1, col2)){
            return new Node(grid[row1][col1] == 1, true, null, null, null, null);
        }
        
        int rowMid = row1 + (row2 - row1) / 2;
        int colMid = col1 + (col2 - col1) / 2 ;
        
        return new Node(false, false,
            build(grid, row1, rowMid, col1, colMid), // Top Left
            build(grid, row1, rowMid, colMid + 1, col2), // Top Right,
            build(grid, rowMid + 1, row2, col1, colMid), // Bottom Left
            build(grid, rowMid + 1, row2, colMid + 1, col2) // Bottom Right
            );
    }
    
    public boolean isLeaf(int[][] grid, int row1, int row2, int col1, int col2) {
        int val = grid[row1][col1];
        
        for(int i = row1; i <= row2; i ++){
            for(int j = col1; j <= col2; j ++){
                if(grid[i][j] != val){
                    return false;
                }
            }
        }
        
        return true;
    }
}