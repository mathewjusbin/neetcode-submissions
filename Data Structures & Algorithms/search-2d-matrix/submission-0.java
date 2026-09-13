class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Treat the 2D matrix like a 1D sorted array
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            // Middle index in the virtual 1D array
            int mid = left + (right - left) / 2;

            // Convert 1D index back to 2D coordinates
            int row = mid / cols;
            int col = mid % cols;

            int value = matrix[row][col];

            if (value == target) {
                return true;
            } else if (value < target) {
                // Search in the right half
                left = mid + 1;
            } else {
                // Search in the left half
                right = mid - 1;
            }
        }

        return false;
    }
}
