class Solution {
    static List<List<Integer>> res;
    public void hasPathSum(TreeNode root, int targetSum, List<Integer> helper) {
        if(root == null) return;

        helper.add(root.val);

        if(root.left == null && root.right == null) {
            if(root.val == targetSum) {
               res.add(new ArrayList<>(helper));
            }
            helper.remove(helper.size() - 1);
            return;
        }

        hasPathSum(root.left, targetSum - root.val, helper);
        hasPathSum(root.right, targetSum - root.val, helper);

        helper.remove(helper.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        hasPathSum(root, targetSum, new ArrayList<>());
        return res;
    }
}