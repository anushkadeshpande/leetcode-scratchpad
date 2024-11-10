class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int i = 0;
        int n = s.length();
        int result = 0;
        
        // skip leading spaces
        while(i<n && s.charAt(i) == ' ')
            i++;
        
        // determine the sign
        if(i<n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            sign = s.charAt(i++) == '-'? -1 : 1;
        // i++;
        // get the number
        while(i<n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if(result > (Integer.MAX_VALUE - digit) / 10)
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                result = (result * 10) + digit; 
            i++;
        }
        
        return result * sign;
    }
}