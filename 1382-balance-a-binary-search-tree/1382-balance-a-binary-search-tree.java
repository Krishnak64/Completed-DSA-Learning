class Solution {
    public void getInorder(TreeNode root,ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.val);
        getInorder(root.right, inorder);

    }
    public TreeNode createBST(ArrayList<Integer> inorder, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = createBST(inorder, start, mid-1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // step 2 -> sorted inorder  -> balanced BST
        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }
}