class Solution {
    public String reversePrefix(String word, char ch) {
        // find ch in word
        // use 2 pointer to reverse that portion
        char[] chars = word.toCharArray();
        int i = 0;
        for(i=0; i<chars.length; i++)
            if(chars[i] == ch)
                break;
        
        // if the char does not exist
        if(i == chars.length)
            return word;
        
        int left = 0;
        while(i > left) {
            char temp = chars[i];
            chars[i] = chars[left];
            chars[left] = temp;
            
            left++;
            i--;
        }
        
        return new String(chars);
    }
}