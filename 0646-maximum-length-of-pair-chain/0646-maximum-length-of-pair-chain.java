class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1])); 
        int n = pairs.length;
        int pairEnd = pairs[0][1];
        int maxLen = 1;

        for(int i=1; i<n; i++) {
            if(pairs[i][0] > pairEnd) {
                pairEnd = pairs[i][1];
                maxLen++;
            }
        }
        return maxLen;
    }
}