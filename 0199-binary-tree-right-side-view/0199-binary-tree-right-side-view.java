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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> helper = new ArrayList<>();
        if(root == null) {
            return helper;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        TreeNode lastNode = null;

        while(!q.isEmpty()) {
            TreeNode currNode = q.remove(); // removing element from queue
            if(currNode == null) {
               helper.add(lastNode.val);
                if(q.isEmpty()) { // null is the last element in the queue so stop it 
                    break;
                } else {
                    q.add(null);// add null at the last to determine when to give next line
                }
            } else { // currNode != null
                    lastNode = currNode;

                    if(currNode.left != null) {
                        q.add(currNode.left);
                    }
                    
                    if(currNode.right != null) {
                        q.add(currNode.right);
                    }

                    
            }

        }
        return helper;
    }
}