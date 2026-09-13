class Solution {
    public int maxArea(int[] heights) {
         int left = 0;
        int right = heights.length-1;
        int maxArea = 0;
        while(left < right){
            int length = Math.min(heights[left],heights[right]);//it should be min or else the water will flow
            int width  = right-left;
            int currentArea = length*width;
            maxArea = Math.max(currentArea, maxArea);
            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }

        }
        return maxArea;
    }
}
