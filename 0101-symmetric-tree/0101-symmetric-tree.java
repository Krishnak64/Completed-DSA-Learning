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
    public boolean isSame(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode leftMirror = invertTree(root.left);
        TreeNode rightMirror = invertTree(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
    
        return root;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true; 
        }

        root.left = invertTree(root.left);
        return isSame(root.left, root.right);
    }
}