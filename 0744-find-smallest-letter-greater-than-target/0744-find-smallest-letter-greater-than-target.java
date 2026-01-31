class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // linear search
        for(char c: letters) {
            if(c > target)
                return c;
        }

        return letters[0];
    }
}