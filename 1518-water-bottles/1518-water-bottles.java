class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalBottles = numBottles;
        
        int leftBottles;
        while(numBottles >= numExchange) {
            // System.out.println(numBottles);
            int exchangedBottles = numBottles / numExchange;
            totalBottles += exchangedBottles;
            leftBottles = numBottles % numExchange;
            numBottles = exchangedBottles + leftBottles;
        }
        // totalBottles += numBottles;
        return totalBottles;
    }
}