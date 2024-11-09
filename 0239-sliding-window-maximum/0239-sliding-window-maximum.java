class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        Deque<Integer> dequeue = new ArrayDeque<>();
        
        // index of nums
        int i = 0;
        int idx = 0;
        
        while(i < n) {
            // remove the ones out of range from the beginning
            if(!dequeue.isEmpty() && dequeue.peek() == i - k) {
                dequeue.poll();
            }
            
            // remove the numbers smaller than current
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[i]) {
                dequeue.pollLast();
            }
            
            dequeue.offer(i);
            
            if(i >= k - 1)
                result[idx++] = nums[dequeue.peek()];
            
            i++;
        }
            
        
        return result;
    }
}