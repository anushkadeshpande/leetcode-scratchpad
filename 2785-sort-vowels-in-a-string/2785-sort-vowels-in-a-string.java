class Solution {
    public String sortVowels(String s) {
        // List<Character> vowels = new ArrayList<>();

        // for(char c: s.toCharArray()) {
        //     if(isVowel(c))
        //         vowels.add(c);
        // }

        // Collections.sort(vowels);
        
        // int j = 0;
        // StringBuilder sb = new StringBuilder(s);
        
        // for(int i=0; i<s.length(); i++) {
        //     if(isVowel(s.charAt(i))) 
        //         sb.setCharAt(i, vowels.get(j++));     
        // }

        // return sb.toString();


        // Approach-2 

        int[] count = new int[100];

        // store frequencies for each vowel
        for(char c: s.toCharArray()) {
            if(isVowel(c))
                count[c - 'A']++;
        }

        StringBuilder sortedString = new StringBuilder();
        String sortedVowels = "AEIOUaeiou";
        int j = 0;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!isVowel(c))
                sortedString.append(c);
            else {
                while(count[sortedVowels.charAt(j) - 'A'] == 0)
                    j++;
                
                sortedString.append(sortedVowels.charAt(j));
                count[sortedVowels.charAt(j) - 'A']--;
            }
        }

        return sortedString.toString();
    }

    public boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c =='U')
            return true;
        return false;
    }
}