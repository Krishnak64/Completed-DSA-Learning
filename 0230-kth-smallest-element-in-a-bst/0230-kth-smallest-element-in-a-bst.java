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
    public void inorderSort(TreeNode root, ArrayList<Integer> sort) {
        if(root == null) {
            return ;
        }
        inorderSort(root.left, sort);
        sort.add(root.val);
        inorderSort(root.right, sort);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> sort = new ArrayList<>();
        inorderSort(root, sort);

        return sort.get(k-1);

    }
}