class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> countMap = new HashMap<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for (int num : nums) {//get the count of occurances
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }
        List<Integer>[] buckets = new List[nums.length+1];
        //Now we are storing this into the bucket using bucket sort
        //the key is the occurance and the list contains the values.
        for (Map.Entry<Integer, Integer> integerIntegerEntry : countMap.entrySet()) {
            int num = integerIntegerEntry.getKey();
            int count = integerIntegerEntry.getValue();
            if(buckets[count] == null){
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(num);
        }
        int[] topKElements = new int[k];//intialized with k since we have only k length that is expected
        int index  = 0;
        //Now based on the k we are looping from the last index
        //Then this value will be stored until it reaches till k
        //in the last bucket there can be n eelemnts but we will stop when it reaches k
        for (int i = nums.length; i >= 0 && index < k ; i--) {//stop when we reached k
            if(buckets[i]  != null){
                for (Integer value : buckets[i]) {
                    topKElements[index] = value;
                    index++;
                    if(index == k) {
                        break;
                    }
                }

            }
        }
        return topKElements;
    }
}
