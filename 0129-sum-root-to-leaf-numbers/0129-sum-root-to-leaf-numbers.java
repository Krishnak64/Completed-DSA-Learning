class Solution {
    public int sum(TreeNode root, int currSum) {
        if(root == null) {
            return 0;
        }
        currSum = currSum * 10 + root.val;
        if(root.left == null && root.right == null) {
            return currSum;
        }
        int leftSum = sum(root.left, currSum);
        int rightSum = sum(root.right, currSum);
        return  leftSum + rightSum;

    }
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
}