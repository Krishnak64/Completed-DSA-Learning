/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
             return null;
        }
        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);

        // leftLca is available but rightLca is empty (it means both lies in left side)
        if(rightLca == null) {
            return leftLca;
        }

        // right is available but leftLca is empty(its means both lies in right side)
        if(leftLca == null){
            return rightLca;
        }

        // it means n1 and n2 lies in right and left side simultaneously
        return root;
    
    }
}