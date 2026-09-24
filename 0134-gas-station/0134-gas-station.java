class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0, totalCost = 0;

        for(int i=0; i<n; i++) {
            totalGas += gas[i];
            totalCost +=cost[i];
        }

        if(totalGas < totalCost) {
            return -1;
        }

        int startIdx = 0, currentCost = 0;

        for(int i=0; i<n; i++) {
            currentCost += gas[i] - cost[i];

            if(currentCost < 0) {
                startIdx = i + 1;
                currentCost = 0;
            }
        }

        return startIdx;
    }
}