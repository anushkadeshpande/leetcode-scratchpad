class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        // number of steps to be taken will be 
        // max of abs(x2-x1) and abs(y2 - y1)
        int numSteps = 0;
        for(int i=1; i<points.length; i++) {
            numSteps += Math.max(Math.abs(points[i][0] - points[i-1][0]), Math.abs(points[i][1] - points[i-1][1]));
        }

        return numSteps;
    }
}