class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();
        
        // find prefixes from arr1
        for(int n: arr1) {
            while(!prefixes.contains(n) && n > 0) {
                prefixes.add(n);
                n = n / 10;
            }
        }
        
        int longestPrefix = 0;
        // find prefixes from arr2
        for(int n: arr2) {
            while(!prefixes.contains(n) && n > 0) {
                n = n / 10;
            }
            
            if(n > 0) {
                longestPrefix = Math.max(longestPrefix, Integer.toString(n).length());
            }
        }
        
        return longestPrefix;
    }
}