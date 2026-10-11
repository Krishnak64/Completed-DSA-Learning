class Solution {
    public void findAllCombination(int idx, int arr[], Set<List<Integer>> set, List<Integer> ds) {
        if(idx == arr.length) {
            
            set.add(new ArrayList<>(ds));

            return;
        }

        // include
        ds.add(arr[idx]);
        
        findAllCombination(idx + 1, arr, set, ds);
        
        ds.remove(ds.size() - 1);
        // not include element condition
        findAllCombination(idx + 1, arr, set, ds);

    }
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        findAllCombination(0, nums, set, new ArrayList<>());
        return new ArrayList<>(set);
    }
}