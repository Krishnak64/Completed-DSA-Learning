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

    public TreeNode delete(TreeNode root, int val){
        if(root == null) {
            return null;
        }
        if(root.val < val){
           root.right = delete(root.right, val);
        } else if(root.val > val) {
            root.left = delete(root.left, val);
        }

        else{ // voila
            // case 1 - leaf node
            if(root.left == null && root.right == null){
                return null; // return null to the root
            }

            //case 2 - single child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case 3 - both children
            TreeNode IS = findInorderSuccessor(root.right);
            root.val = IS.val;
            root.right = delete(root.right, IS.val);

        }
        return root;
    }

    public TreeNode findInorderSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }
}