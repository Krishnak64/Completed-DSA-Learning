/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    public void leaveSum(TreeNode root, char l) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null && l == 'l') {
            sum += root.val;
        }

        leaveSum(root.left, 'l');
        leaveSum(root.right, 'r');
    }
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        leaveSum(root, 'c');
        return sum;
    }
}