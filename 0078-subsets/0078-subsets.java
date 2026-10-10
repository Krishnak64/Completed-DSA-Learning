class Solution {
    public void findAllCombination(int idx, int arr[], List<List<Integer>> res, List<Integer> ds) {
        if(idx == arr.length) {
            
            res.add(new ArrayList<>(ds));

            return;
        }

        // include
        ds.add(arr[idx]);
        
        findAllCombination(idx + 1, arr, res, ds);
        ds.remove(ds.size() - 1);
        // not include element condition
        findAllCombination(idx + 1, arr, res, ds);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        findAllCombination(0, nums, res, new ArrayList<>());
        return res;
    }
}