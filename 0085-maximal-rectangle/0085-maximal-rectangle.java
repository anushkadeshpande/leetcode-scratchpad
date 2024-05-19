class Solution {
    
    private int calculateMaxArea(int[] heights) {
        // logic same as maximum height histogram
        
        Stack<Integer> stack = new Stack<>();
        int[] maxArea = new int[heights.length];
        int area = Integer.MIN_VALUE;
        
        // 1. find min to the left (record index)
        // 2. find min to right (record index)
        // 3. find the number of bars in between
        // 4. find out the max area
        for(int i=0; i<heights.length; i++) {
            while(!stack.empty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            
            maxArea[i] = stack.empty()? -1 : stack.peek();
            
            stack.push(i);   
        }
        
        while(!stack.empty())
            stack.pop();
        
        for(int i=heights.length - 1; i>=0; i--) {
            while(!stack.empty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            
            maxArea[i] = stack.empty()? heights.length - maxArea[i] - 1 : stack.peek() - maxArea[i] - 1;
            
            stack.push(i);
        }
        
        for(int i=0; i<heights.length; i++) {
            area = Math.max(area, heights[i] * maxArea[i]);
        }
        
        return area;
    }
    
    private int[] buildHistogram(char[][] matrix, int idx) {
        int[] heights = new int[matrix[0].length];
        
        for(int i=0; i<=idx; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
        }
        
        return heights;
    }
    
    public int maximalRectangle(char[][] matrix) {
        // Similar to max area histogram question
        // every row can be considered as a histogram
        int maxHeight = Integer.MIN_VALUE;
        if(matrix.length == 1 && matrix[0].length == 1) {
            if(matrix[0][0] == '1')
                return 1;
            else 
                return 0;
        }

        for(int i=0; i< matrix.length; i++) {
            // create a histogram type arr
            // i.e calculate the max height so far
            
            int[] heights = buildHistogram(matrix, i);
            
            maxHeight = Math.max(calculateMaxArea(heights), maxHeight);

        }
        
        return maxHeight;
    }
}