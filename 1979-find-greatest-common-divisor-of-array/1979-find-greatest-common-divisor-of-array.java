class Solution {
    public int findGCD(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        
        for(int num: nums) {
            if(num < smallest)
                smallest = num;
            
            if(num > largest)
                largest = num;
        }
        
        // find gcd
        for(int i=smallest; i>=0; i--) {
            if(smallest % i == 0 && largest % i == 0)
                return i;
        }
        
        return 1;
    }
}