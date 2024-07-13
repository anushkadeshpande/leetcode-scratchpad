class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        // List<Integer> sol = new ArrayList<>();
        int size = digits.length; 
        
        if(digits[size - 1] <= 8) {
            digits[size - 1] += 1;
            
            return digits;
        }
        
        for(int i= size- 1; i>=0; i--) {
            int sum = digits[i] + carry;
            if(sum == 10) {
                carry = 1;
                sum = 0;
            } else {
                carry = 0;
            }
            
            digits[i] = sum;
        }
        
        if(carry == 1)
            size++;
        
        int[] res = new int[size];
        for(int i=digits.length-1; i>=0; i--) {
            res[i] = digits[i];
        }
        if(carry == 1)
            res[0] = 1;
        return res;
    }
}