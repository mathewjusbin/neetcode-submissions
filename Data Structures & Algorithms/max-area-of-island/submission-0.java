class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        if(grid == null || grid.length == 0){
            return maxArea;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(grid[r][c] == 1){
                    maxArea =Math.max(dfs(grid, r , c),maxArea);
                }
            }
        }
        return maxArea;
    }
     private int dfs(int[][] grid, int r, int c) {
        
        int rows = grid.length;
        int cols = grid[0].length; //These are for boundary check
        if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0){
            return 0;
        }
        
        grid[r][c] =0;
        int isLandCount=1;
        isLandCount+=dfs(grid,r+1,c);
        isLandCount+=dfs(grid,r-1,c);
        isLandCount+=dfs(grid,r,c+1);
        isLandCount+=dfs(grid,r,c-1);
        return isLandCount;
    }
}
