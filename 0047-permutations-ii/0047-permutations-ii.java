class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    public void helper(int[] nums, List<Integer> lst){
        if(lst.size() == nums.length) {
            ans.add(new ArrayList(lst));
            return;
        }

        for(int i=0; i<nums.length;i++) {
            if(nums[i] != -11){ // -11 indicate that it is visited
               int temp = nums[i];
               lst.add(temp);
               nums[i] = -11;
               helper(nums, lst);
               lst.remove(lst.size()-1);
               nums[i] = temp;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new HashSet<>();
        helper(nums, new ArrayList<>());
        return new ArrayList<>(ans);
    }
}