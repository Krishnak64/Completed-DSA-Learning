class Solution {
    public TreeNode removeLeaf(TreeNode root, int target) {
        if(root == null) {
            return null;
        }
        
        root.left = removeLeaf(root.left, target);
        root.right = removeLeaf(root.right, target);
  
        if(root.left == null && root.right == null && root.val == target) {
            return null;
        }
        
        return root;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return removeLeaf(root, target);
    }
}