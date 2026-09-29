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
    public TreeNode deleteLeaf(TreeNode root, int x) {
        if (root == null)
            return null;

        // Recurse first
        root.left = deleteLeaf(root.left, x);
        root.right = deleteLeaf(root.right, x);

        // If it's a leaf node and data == x, delete it
        if (root.left == null && root.right == null && root.val == x) {
            return null;
        }

        return root;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return deleteLeaf(root, target);
    }
}