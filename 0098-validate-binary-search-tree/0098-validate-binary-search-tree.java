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

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> sort = new ArrayList<>();
        inorderSort(root, sort); 
        for (int i = 1; i < sort.size(); i++) {
            if (sort.get(i) <= sort.get(i - 1)) { // determing that it is sorted or not
                return false; // Found an element smaller than its predecessor
            }
        }
        return true;
    }
}