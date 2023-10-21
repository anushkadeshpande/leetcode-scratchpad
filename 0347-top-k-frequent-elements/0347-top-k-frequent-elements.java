class Solution {
        public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int i;
        for(i = 0 ; i < nums.length; i++) {
            if(frequencyMap.get(nums[i]) == null) 
                frequencyMap.put(nums[i], 1);
            else 
                frequencyMap.put(nums[i], frequencyMap.get(nums[i]) + 1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> frequencyMap.get(a) - frequencyMap.get(b));
            
        for(int num: frequencyMap.keySet()) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
            
         int[] result = new int[minHeap.size()];
        i = 0;
        while(!minHeap.isEmpty())
            result[i++] = minHeap.poll();
            
        return result;
    }
}