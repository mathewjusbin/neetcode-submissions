class Solution {
    public int search(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;
        //keep searching until there is a valid range
        while(left <= right){
            int mid = left +(right-left)/1;
            //If the middle element is the target the return the index
            if(nums[mid] == target){
                return mid;
            }
            //Check weather the left half is sorted
            if(nums[left]<= nums[mid])
            {
                //search the element in the sorted left half
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{//right part is sorted
                if(nums[right] >= target && target > nums[mid]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
