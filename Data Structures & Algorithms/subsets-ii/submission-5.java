class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            Arrays.sort(nums);
            backtrack(0, nums, current, result);
            return result;
    }
    public void backtrack(int index,int[] nums,List<Integer> current,List<List<Integer>> result){
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Decision 1: INCLUDE the current element nums[i]
        current.add(nums[index]);
        backtrack(index + 1, nums, current, result);


        // Backtrack (undo the inclusion)
        current.remove(current.size() - 1);
        // Decision 2: EXCLUDE the current element nums[i]
        // If we exclude nums[i], we MUST also exclude all adjacent duplicates
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        backtrack(index + 1, nums, current, result);
    }
}
