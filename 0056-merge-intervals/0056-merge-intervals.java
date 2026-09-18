class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        list.add(intervals[0]);

        for(int i=1; i<intervals.length ; i++) {
            int prev[] = list.get(list.size() - 1);
            int next[] = intervals[i];
            if(prev[1] >= next[0]) {
                prev[1] = Math.max(prev[1], next[1]);
            } else {
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[list.size()-1][2]);
    }
}