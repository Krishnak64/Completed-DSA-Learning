
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

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // sort first to group duplicates
        Set<List<Integer>> set = new HashSet<>(); // store non-duplicate elements

        findAllCombination(0, nums, set, new ArrayList<>());
        return new ArrayList<>(set);
    }
}
