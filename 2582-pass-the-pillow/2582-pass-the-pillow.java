class Solution {
    public int passThePillow(int n, int time) {
        // coming back
        if((time/(n-1)) % 2 != 0) {
            return n - (time % (n-1));
        }
        return (time % (n-1)) + 1;
    }
}