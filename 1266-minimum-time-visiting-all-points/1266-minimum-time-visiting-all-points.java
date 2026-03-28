class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        // min time it'd take to go from point 1 -> point 2 will be max of |x1-x2| and |y1-y2|
        int minTime = 0;

        for(int i=1; i<points.length; i++) {
            minTime += Math.max(Math.abs(points[i-1][0]-points[i][0]), Math.abs(points[i-1][1]-points[i][1]));
        } 

        return minTime;
    }
}