class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for(int n: nums) {
            int count = 0;
            if(frequencyMap.containsKey(n))
                count = frequencyMap.get(n);
            
            count++;
            
            frequencyMap.put(n, count);
        }   
        
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? b.getKey() - a.getKey() : a.getValue() - b.getValue());
        
        for(int key: frequencyMap.keySet()) {
            minHeap.add(new Pair(key, frequencyMap.get(key)));
        }
        
        int[] sortedArr = new int[nums.length];
        int j = 0;
        while(!minHeap.isEmpty()) {
            Pair<Integer, Integer> pair = minHeap.poll();
            
            for(int i=0; i<pair.getValue(); i++)
                sortedArr[j++] = pair.getKey();
        }
        
        return sortedArr;
    }
}