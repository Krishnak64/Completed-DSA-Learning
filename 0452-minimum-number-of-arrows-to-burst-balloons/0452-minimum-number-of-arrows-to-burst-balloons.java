class Solution {
    public int findMinArrowShots(int[][] points) {
        int maxAct = 1;
        int n = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int lastEnd = points[0][1];
        for(int i=1;i<n;i++) {
        // if start time of current activity is greater than or equal to last end time
            if(points[i][0] > lastEnd) {
                maxAct++;
                lastEnd = points[i][1]; // update last end time
            }
        }
        return maxAct;
    }
}