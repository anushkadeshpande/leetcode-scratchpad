class Solution {
    public int possibleStringCount(String word) {
        int count = 0;
        int j = 1;      
        for(int i=0; i<word.length() - 1; i++, j++) {            
            if(word.charAt(i) == word.charAt(j)) 
                count++;
        }
        return count+1;
    }
}