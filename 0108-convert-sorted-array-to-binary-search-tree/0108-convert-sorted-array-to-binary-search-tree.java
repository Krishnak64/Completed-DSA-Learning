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
    public TreeNode sortedTree(int[] arr, int start, int end){ // O(N)
        if(start > end) {// invalid  
            return null;
        }
        int mid = start + (end - start)/2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = sortedTree(arr, start, mid - 1);
        root.right = sortedTree(arr, mid + 1, end);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return sortedTree(nums, 0, n - 1);
    }
}