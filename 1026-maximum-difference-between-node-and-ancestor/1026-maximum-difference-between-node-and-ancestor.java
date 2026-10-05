
class Solution {
    static List<List<Integer>> res;
    public void hasPathSum(TreeNode root, List<Integer> helper) {
        if(root == null) return;

        helper.add(root.val);

        if(root.left == null && root.right == null) {
            res.add(new ArrayList<>(helper));
            helper.remove(helper.size() - 1);
            return;
        }

        hasPathSum(root.left,  helper);
        hasPathSum(root.right, helper);

        helper.remove(helper.size() - 1);
    }
    public int maxAncestorDiff(TreeNode root) {
        res = new ArrayList<>();
        hasPathSum(root, new ArrayList<>());
        int max = 0;

        for (List<Integer> path : res) {
            Collections.sort(path);
            max = Math.max(max, Math.abs(path.get(0) - path.get(path.size() - 1)));
        }
        return max;
    }
}