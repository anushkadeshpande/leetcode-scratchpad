class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // add the absolute differences to the min heap
        
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            // if the difference is the same, return the one with smaller key
            if(b.getValue().equals(a.getValue())) 
                return b.getKey() - a.getKey();
            else return b.getValue() - a.getValue();
        });
        
        for(int n: arr) {
            // find diff
            int diff = Math.abs(n - x);
            
            maxHeap.add(new Pair<>(n, diff));
            
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        List<Integer> closestElements = new ArrayList<>();
        while(!maxHeap.isEmpty())
            closestElements.add(maxHeap.poll().getKey());
        
        Collections.sort(closestElements);
        
        return closestElements;
    }
}