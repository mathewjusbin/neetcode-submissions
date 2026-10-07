class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        if(queue.isEmpty()){
            return;
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int[] direction : directions) {
                int nr = r+direction[0];
                int nc = c+direction[1];
                //boundary check
                if(nr<0||nc<0||nr>=rows||nc>=cols||grid[nr][nc]!= Integer.MAX_VALUE){
                    continue;
                }
                grid[nr][nc] = grid[r][c]+1;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
