class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        // find total number of apples
        // sort capacity in descending order
        // while num_apple > 0, decrease one one element from capacity array
        // count the number of elements decreased from capacity

        int numApple = 0;
        for(int a: apple)
            numApple += a;

        Arrays.sort(capacity);
        
        int i = capacity.length - 1;
        int count = 0;
        while(numApple > 0 && i >= 0) {
            numApple -= capacity[i--];
            count ++;
        }

        return count;
    }
}