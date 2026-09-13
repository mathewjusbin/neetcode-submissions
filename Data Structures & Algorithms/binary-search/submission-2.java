class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            //int mid = left+(right-left)/2;
            if(nums[left+(right-left)/2] == target){
                return left+(right-left)/2;
            }else if(nums[left+(right-left)/2] < target){
                left = left+(right-left)/2+1;
            }else{
                right = left+(right-left)/2-1;
            }
        }
        return -1;
    }
}
