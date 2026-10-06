class Solution {        
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null && root.val != val) {
            return null;
        }

        if(root.left == null && root.right == null && root.val == val) {
            return new TreeNode(val);
        }

        if(val < root.val) {
         return searchBST(root.left, val);
       }
       else if(val > root.val){
            return searchBST(root.right, val);
       } 
       else {
           return root;
       }
    }
}