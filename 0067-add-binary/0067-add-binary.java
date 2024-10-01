class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length();
        int j = b.length();
        String result = "";
        
        while(i > 0 && j > 0) {
            char aBit = a.charAt(i-1);
            char bBit = b.charAt(j-1);
            
            if(aBit == '1' && bBit == '1') {
                if(carry == 1)
                    result = "1" + result;
                else
                    result = "0" + result;
                carry = 1;
            } else if(aBit == '0' && bBit == '0') {
                if(carry == 1)
                    result = "1" + result;
                else
                    result = "0"  + result;
                carry = 0;
            } else {
                // if either of them is 1
                if(carry == 1) {
                    result = "0" + result;
                    carry = 1;
                }
                else {
                    result = "1" + result;
                    carry = 0;
                }
            }
            
            i--;
            j--;
        }
        
        char bit;
        
        while(i > 0) {
            bit = a.charAt(i-1);
            if(bit == '1') {
                if(carry == 1) {
                    result = "0" + result;
                    carry = 1;
                } else {
                    result = "1" + result;
                    carry = 0;
                }
            } else {
                if(carry == 1) {
                    result = "1" + result;
                    carry = 0;
                } else {
                    result = "0" + result;
                    carry = 0;
                }
            }
            i--;
        }
        
        while(j > 0) {
            bit = b.charAt(j-1);
            if(bit == '1') {
                if(carry == 1) {
                    result = "0" + result;
                    carry = 1;
                } else {
                    result = "1" + result;
                    carry = 0;
                }
            } else {
                if(carry == 1) {
                    result = "1" + result;
                    carry = 0;
                } else {
                    result = "0" + result;
                    carry = 0;
                }
            }
            j--;
        }    
        
        if(carry == 1)
            result = "1" + result;
        
        return result;
    }
}