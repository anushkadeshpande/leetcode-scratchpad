class Solution {
    public int missingMultiple(int[] nums, int k) {
        // put nums in a set
        // check if multiples of k are present

        Set<Integer> numbers = new HashSet<>();
        
        for(int n: nums)
            numbers.add(n);

        int multiplier = 2;
        int multiple = k;
        
        while(true) {
            if(!numbers.contains(multiple))
                return multiple;
            else {
                multiple = k * multiplier;
                multiplier++;
            }
        }

        // return k;
    }
}