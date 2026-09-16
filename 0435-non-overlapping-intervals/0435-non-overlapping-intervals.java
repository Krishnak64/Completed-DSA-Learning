class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int maxAct = 0;
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int lastEnd = intervals[0][1];
        for(int i=1;i<n;i++) {
        // if start time of current activity is greater than or equal to last end time
            if(intervals[i][0] >= lastEnd) {
                maxAct++;
                lastEnd = intervals[i][1]; // update last end time
            }
        }

        return n - maxAct - 1;
    }
}