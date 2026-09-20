class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b)-> Integer.compare(a[0] - b[0], a[1] - b[1]));
        int n = costs.length;
        int total = 0;

        for(int i=0; i<n/2; i++) {
            total += costs[i][0];
        }

        for(int i=n/2; i<n; i++) {
            total += costs[i][1];
        }

        return total;
    }
}