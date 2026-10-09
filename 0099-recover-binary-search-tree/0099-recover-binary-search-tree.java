class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode prevprev = null;
        List<TreeNode> arr = new ArrayList<>();
        //Morris Traversal
        while(curr!=null){
            if(curr.left!=null){
              TreeNode pred = curr.left;
              while(pred.right!=null && pred.right!=curr){
                pred = pred.right;
              }
              if(pred.right==null){
                pred.right = curr;
                curr = curr.left;
              }
              if(pred.right==curr){ // unlink
                pred.right = null;
                if(prev!=null && prevprev!=null){
                    if(prev.val>curr.val && prev.val > prevprev.val) arr.add(prev);
                    if(prev.val<curr.val && prev.val < prevprev.val) arr.add(prev);
                }
                else if(prev!=null && prev.val>curr.val) arr.add(prev);
                prevprev = prev;
                prev = curr;
                curr = curr.right;
              }
            }
              else{ // curr.left = null, no pred
                if(prev!=null && prevprev!=null){
                    if(prev.val>curr.val && prev.val > prevprev.val) arr.add(prev);
                    if(prev.val<curr.val && prev.val < prevprev.val) arr.add(prev);
                }
                else if(prev!=null && prev.val>curr.val) arr.add(prev);
                prevprev = prev;
                prev = curr;
                curr = curr.right;
              }
        }
        if(prev.val<prevprev.val) arr.add(prev);
         TreeNode first = arr.get(0);
         TreeNode second = arr.get(arr.size()-1); // last element of arr
         int temp = first.val;
         first.val = second.val;
         second.val = temp;
         
    }
    
    
}