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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) {
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> helper = new ArrayList<>();
        boolean leftToRight = true;

        while(!q.isEmpty()) {
            TreeNode currNode = q.remove(); // removing element from queue
            if(currNode == null) {

                if(!leftToRight) {
                    Collections.reverse(helper);
                }

                res.add(helper); // if currNode is null then give space to print line
                helper = new ArrayList<>();
                leftToRight = !leftToRight;

                if(q.isEmpty()) { // null is the last element in the queue so stop it 
                    break;
                } else {
                    q.add(null);// add null at the last to determine when to give next line
                }
            } else { // currNode != null
                    helper.add(currNode.val);

                    // adding left and right in queue
                    if(currNode.left != null) {
                        q.add(currNode.left);
                    }

                    if(currNode.right != null) {
                        q.add(currNode.right);
                    }
            }

        }
        return res;
    }
}