class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(used, current, nums, result);
        return result;
    }
    public void backtrack(boolean[] used,List<Integer> current,int[] nums,List<List<Integer>> result){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));//Why new of arraylist is we are calling each
            //method with current so the value changes
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            used[i] = true;
            backtrack(used,current,nums,result);

            current.remove(current.size()-1);
            used[i] = false;
        }
    }
}