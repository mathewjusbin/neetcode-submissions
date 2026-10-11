class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() >= 2) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            int result;
            if(first > second){
                result = first - second;
            }else {
                result = second - first;
            }
                maxHeap.offer(result);
            
        }
        return maxHeap.peek();
    }
}
