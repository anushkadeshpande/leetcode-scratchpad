class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<Integer> spiralElements = new ArrayList<>();
        
        int count = m * n;
        
        int k = 0;
        
        int top = 0;
        int left = 0;
        int right = n-1;
        int bottom = m-1;
        
        while(count > 0) {
        
            // go left to right in the top row
            for(k=left; k<=right; k++) {
                spiralElements.add(matrix[top][k]);
                count--;
                if(count == 0)
                    break;
            }
            
            top++;
            
            if(count == 0)
                break;
            
            // go top to bottom in the right column
            for(k=top; k<=bottom; k++) {
                spiralElements.add(matrix[k][right]);
                count--;
                if(count == 0)
                    break;
            }
            
            right--;
            
            if(count == 0)
                    break;
            
            // go from right to left in the bottom row
            for(k=right; k>=left; k--) {
                spiralElements.add(matrix[bottom][k]);
                count --;
                if(count == 0)
                    break;
            }
            
            bottom--;
            
            if(count == 0)
                break;
            
            // go from bottom to top in the left column
            for(k=bottom; k>=top; k--) {
                spiralElements.add(matrix[k][left]);
                count--;
                if(count == 0)
                    break;
            }
            
            left++;
            
            if(count == 0)
                break;
        }
        return spiralElements;
    } 
}