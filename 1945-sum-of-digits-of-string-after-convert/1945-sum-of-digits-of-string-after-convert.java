class Solution {
    public int getLucky(String s, int k) {
        // convert to number
        String number = convertToNumber(s);
        
        return transform(number, k);
    }
    
    public String convertToNumber(String s) {
        String result = "";
        for(int i=0; i<s.length(); i++) {
            result += String.valueOf(s.charAt(i) - 'a' + 1);
        }
        
        return result;
    }
    
    public int transform(String number, int k) {
        String n = number;
        for(int i=0; i<k; i++) {
            long num = 0;
            for(int j=0; j<n.length(); j++) {
                num += n.charAt(j) - '0';
            }
            n = String.valueOf(num);
        }
        
        return Integer.parseInt(n);
    }
}