class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> traversal = new ArrayList<>();
        int numElements = matrix.length * matrix[0].length;
        int count = 0;

        while(count != numElements) {
            // top left to top right
            for(int i=left; i<= right; i++) {
                traversal.add(matrix[top][i]);
                count++;
            }
            top++;
            if(count == numElements)
                break;

            // top right to bottom right
            for(int i=top; i<= bottom; i++) {
                traversal.add(matrix[i][right]);
                count++;
            }
            right--;
            if(count == numElements)
                break;

            // bottom right to bottom left
            for(int i=right; i >= left; i--) {
                traversal.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            
            if(count == numElements)
                break;

            // bottom left to top left
            for(int i=bottom; i >= top; i--) {
                traversal.add(matrix[i][left]);
                count++;
            }
            left++;

            if(count == numElements)
                break;

        }

        return traversal;
    }
}