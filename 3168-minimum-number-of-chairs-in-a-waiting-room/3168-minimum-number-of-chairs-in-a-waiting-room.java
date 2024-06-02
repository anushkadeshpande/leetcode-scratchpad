class Solution {
    public int minimumChairs(String s) {
        int chairsRequired = 0;
        int maxChairsRequired = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'E') {
                chairsRequired++;
                maxChairsRequired = Math.max(chairsRequired, maxChairsRequired);
            }
            else
                chairsRequired --;
        }
        
        return maxChairsRequired;
    }
}