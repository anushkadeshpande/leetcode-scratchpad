class Solution {
    public int largestRectangleArea(int[] heights) {
        // find smaller on the left and right
        // find num bars between current and the previous and next smaller
        // area = (num_bars_left + num_bars_right) * height[i]
        
        Stack<Integer> stack = new Stack<>();
        int[] numBars = new int[heights.length];
        
        // 1. Find smaller on left
        for(int i=0; i<heights.length; i++) {
            while(!stack.empty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }
            
            numBars[i] = stack.size() == 0 ? -1 : stack.peek();
            
            stack.push(i);
        }
        
        // empty the stack
        while(!stack.empty())
            stack.pop();

        // 2. Find smaller on right
        for(int i=heights.length -1; i>=0; i--) {
            
            while(!stack.empty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }

            numBars[i] = stack.empty()? heights.length - 1 - numBars[i] : stack.peek() - numBars[i] - 1;
            
            stack.push(i);
        }
        
        // 3. find max area
        int area = -1;
        for(int i=0; i<heights.length; i++) {
            area = Math.max(area, numBars[i] * heights[i]);
        }
        
        return area;
    }
}