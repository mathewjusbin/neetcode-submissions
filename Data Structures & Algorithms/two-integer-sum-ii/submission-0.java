class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left =0;
        int right = numbers.length-1;
        while(left < right){
            int sum = numbers[left]+numbers[right];
            if(sum == target){
                return new int[]{left+1, right+1};
            }else if(sum > target){ //No need to use left<right because if left=right we will be using the duplicate
                //elements which is not allowed
                right--;
            }else {
                left++;
            }

        }
        return new int[]{};
    }
}
