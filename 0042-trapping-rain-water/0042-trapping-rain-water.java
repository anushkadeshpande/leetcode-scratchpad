class Solution {
    public int trap(int[] height) {
        
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int[] level = new int[height.length];
        int answer = 0;
        
        // 1. find max height from right
        rightMax[height.length - 1] = height[height.length - 1];
        for(int i=height.length - 2; i>= 0; i--)
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        
        // 2. find max height from left
        // 3. and find min of the max heights (level)

        leftMax[0] = height[0];
        level[0] = Math.min(leftMax[0], rightMax[0]);
        
        // 4. answer will be sum of level[i] - height[i]
        answer += level[0] - height[0];
        
        for(int i=1; i<height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
            level[i] = Math.min(leftMax[i], rightMax[i]);
                
            answer += level[i] - height[i];
        }
        
        return answer;
    }
}