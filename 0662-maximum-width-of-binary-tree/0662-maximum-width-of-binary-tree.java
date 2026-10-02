class Solution {
    public class Node{
        TreeNode node;
        int idx;
        Node(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));
        int max = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int start = 0, end = 0;
            for(int i=0 ; i<size; i++) {
                Node currEle = q.remove();
                int index = currEle.idx;

                if(i == 0) {
                    start = index;
                }

                if(i == size-1) {
                    end = index;
                }
                if(currEle.node.left != null) {
                    q.add(new Node(currEle.node.left, 2*currEle.idx));
                }

                if(currEle.node.right != null) {
                    q.add(new Node(currEle.node.right, 2*currEle.idx + 1));
                }
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}