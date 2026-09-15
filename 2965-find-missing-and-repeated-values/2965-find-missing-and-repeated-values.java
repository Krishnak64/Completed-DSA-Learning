class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = n * n;
        int freq[] = new int[total + 1];

        for(int row[] : grid) {
            for(int num : row) {
                freq[num]++;
            }
        }

        int missing = -1;
        int repeated = -1;

        for (int i = 1; i <= total; i++) {
            if (freq[i] == 2) {
                repeated = i;
            } else if (freq[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeated, missing};
    }
}