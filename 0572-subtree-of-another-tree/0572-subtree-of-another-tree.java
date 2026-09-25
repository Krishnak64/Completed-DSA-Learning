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
    public boolean isIdentical(TreeNode node, TreeNode subroot) {
        if(node == null && subroot== null) {
            return true;
        } else if(node == null || subroot == null || node.val != subroot.val ){
             return false;
        }

        if(isIdentical(node.left, subroot.left) != true) {
            return false;
        }
        if(isIdentical(node.right, subroot.right) != true) {
            return false;
        }
        return true;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }

        if(root.val == subRoot.val) { // match ho gaya ki subroot kaha par hai main root mai
            if(isIdentical(root, subRoot) == true) { // checking ki root and subroot is identical or not
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); // checking ki kaha par subroot and main root match kar rahe ha(khonsi side me)
    }
}