class Solution {
    public void reverseString(char[] s) {
        // using 2 pointer approach
        int left = 0;
        int right = s.length - 1;
        char temp;
        while(left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            left ++;
            right --;
        }
    }
}