
class Solution {
    public void inorderSort(TreeNode root, Set<Integer> set) {
        if(root == null) {
            return ;
        }
        inorderSort(root.left, set);
        set.add(root.val);
        inorderSort(root.right, set);
    }
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> sort = new HashSet<>();
        inorderSort(root, sort);

        List<Integer> list = new ArrayList<>(sort);
        Collections.sort(list);
        if(list.size() >= 2) {
            return list.get(1);
        }

        return -1;
    }
}