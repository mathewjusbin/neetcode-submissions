class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> resultSet = new HashSet();
        for(Integer num : nums){
            if(!resultSet.add(num)){
                return true;
            }
        }
        return false;
    }
}