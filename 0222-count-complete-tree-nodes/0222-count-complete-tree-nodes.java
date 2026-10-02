class Solution {
    public int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);

        if(leftDepth == rightDepth) {
            return (int)Math.pow(2, leftDepth) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public  int leftDepth(TreeNode root) {
        int depth = 0;
        while(root != null) {
            root = root.left;
            depth++;
        }

        return depth;
    }

    public  int rightDepth(TreeNode root) {
        int depth = 0;
        while(root != null) {
            root = root.right;
            depth++;
        }

        return depth;
    }
}