class Solution {
    public int maxFreqSum(String s) {
        // count freq of all chars
        // get max
        int[] count = new int[26];

        int maxCountV = 0;
        int maxCountC = 0;

        for(char c: s.toCharArray()) {
            count[c - 'a']++;
            if(isVowel(c))
                maxCountV = Math.max(maxCountV, count[c - 'a']);
            else
                maxCountC = Math.max(maxCountC, count[c - 'a']);
        }

        return maxCountV + maxCountC;
    }

    public boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}