class Solution {
    public int longestConsecutive(int[] nums) {
     Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestSequence = 0;

        for (int num : nums) {
            if(!numSet.contains(num-1)){
                int length = 1;
                while(numSet.contains(num+1)){
                    length++;
                    num++;
                }
                longestSequence = Math.max(length,longestSequence);
            }
        }
        return longestSequence;   
    }
}
