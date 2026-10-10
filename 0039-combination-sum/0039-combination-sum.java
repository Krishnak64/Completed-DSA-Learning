class Solution {
    public void findAllCombination(int idx, int arr[], int target, List<List<Integer>> res, List<Integer> ds) {
        if(idx == arr.length) {
            if(target == 0) {
                res.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[idx] <= target) {
            ds.add(arr[idx]);
            // include element
            findAllCombination(idx, arr, target - arr[idx], res, ds);
            ds.remove(ds.size() - 1);
        }

        // not include
        findAllCombination(idx+1, arr, target, res, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findAllCombination(0, candidates, target, res, new ArrayList<>());
        return res;
    }
}