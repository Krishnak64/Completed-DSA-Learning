class Solution {
    public void findCombination(int idx, int arr[], int target, List<List<Integer>> ans, List<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx; i < arr.length; i++) {
            // skip duplicates
            if(i > idx && arr[i] == arr[i-1]) continue;

            if(arr[i] > target) break; // pruning

            ds.add(arr[i]);
            // move to i+1 (not i) because we cannot reuse same element
            findCombination(i+1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // important for duplicate handling
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
