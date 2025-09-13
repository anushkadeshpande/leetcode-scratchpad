class Solution {
    public boolean doesAliceWin(String s) {
        // get number of vowels in s
        // if string has odd number of vowels, alice wins
        // if string has even vowels, alice removes something, then bob removes some even number of vowels and then alice is left with odd number of vowels
        // so, in any case alice wins
        // hence, if there is atleast one vowel in the string, alice wins

        for(char c: s.toCharArray()) {
            if(isVowel(c))
                return true;
        }

        return false;
    }

    public boolean isVowel(char c) {

        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;

        return false;
    }
}