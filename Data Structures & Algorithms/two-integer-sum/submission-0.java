class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> needed = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];

            if(needed.containsKey(difference)){
                return new int[]{needed.get(difference), i};
            }else{
                needed.put(nums[i],i );
            }
        }
    return new int[]{};//Just retrun an empty array instead, dont return 0,0 that will milead
    }
}
