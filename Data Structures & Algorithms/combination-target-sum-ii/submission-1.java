class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backTrack(0,0, target,new ArrayList<>(),candidates,result);
        return result;
    }
    public void backTrack(int index, int total, int target, List<Integer> current, int[] nums, List<List<Integer>> result){
        if(total == target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(index >= nums.length || total > target){
            return;
        }
        //Since we can choose the same number any num times
        current.add(nums[index]);//Just add this to the current
        backTrack(index+1, total+nums[index],target, current,nums,result);

        //Lets say the total is greater than the target hence we have to remove one
        // and check in the next subtree for the other value
        //Why just total is we are not planning to add the last element so we are removing
        //it from the sum thats it
        //Since we are not considering that last element remove it from the array
        current.remove(current.size()-1);
        while(index+1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }
        backTrack(index+1, total,target,current,nums,result);

    }
}
