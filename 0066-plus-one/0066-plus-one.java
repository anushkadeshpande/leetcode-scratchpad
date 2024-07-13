class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        List<Integer> sol = new ArrayList<>();
        for(int i=digits.length - 1; i>=0; i--) {
            int sum = digits[i] + carry;
            if(sum == 10) {
                carry = 1;
                sum = 0;
            } else {
                carry = 0;
            }
            
            sol.add(sum);
        }
        if(carry == 1)
            sol.add(carry);
        
        int[] res = new int[sol.size()];
        for(int i=res.length-1; i>=0; i--) {
            res[i] = sol.get(res.length-1-i);
        }
        
        return res;
    }
}