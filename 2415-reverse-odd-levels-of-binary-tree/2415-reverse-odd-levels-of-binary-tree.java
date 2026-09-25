
class Solution {
    public  void swapOddLevels(TreeNode l,TreeNode r, int parLevel) {
        if(l == null && r == null) {
            return ;
        }

        // level of curr is odd and left or right of curr not be null
        if(parLevel % 2 == 1) {
            int temp = l.val;
            l.val = r.val;
            r.val = temp;
        }

        // like two pointer approach
        swapOddLevels(l.left, r.right, parLevel + 1);
        swapOddLevels(l.right, r.left, parLevel + 1);

        return ;
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        if(root.left == null && root.right == null) {
            return root;
        }
        swapOddLevels(root.left,root.right, 1);

        return root;
    }
}