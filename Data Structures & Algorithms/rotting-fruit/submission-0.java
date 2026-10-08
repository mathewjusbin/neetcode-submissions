class Solution {
    public int orangesRotting(int[][] grid) {
         Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;//There are no fresh fruits
        }
        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        int minutes =0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isRottan = false;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int nr = current[0];
                int nc = current[1];
                for (int[] direction : directions) {
                    int r = nr + direction[0];
                    int c = nc + direction[1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        if (grid[r][c] == 1) {
                            grid[r][c] = 2;
                            fresh--;
                            queue.offer(new int[]{r, c});
                            isRottan = true;
                        }
                    }
                }
            }
            if (isRottan) {
                minutes++;
            }
        }
        if (fresh > 0) {
            return -1;
        }
        return minutes;
    }
}
