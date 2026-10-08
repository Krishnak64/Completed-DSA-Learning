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
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            // Base case: create new node if root is null
            return new TreeNode(val);
        }

        if (val < root.val) {
            // Go to left subtree
            root.left = insert(root.left, val);
        } else {
            // Go to right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }
}