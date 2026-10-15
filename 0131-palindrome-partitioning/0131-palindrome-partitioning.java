class Solution {
    List<List<String>> res = new ArrayList<>();
    int n;

    public boolean isPalindrom(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            end--;
            start++;
        }
        return true;
    }

    public void recur(String s, int partIdx, List<String> sublist) {
        // base case
        if(partIdx == n) {
            res.add(new ArrayList<>(sublist));
            return;
        }

        // explore the poss
        for(int end = partIdx; end < n; end++) {
            if(isPalindrom(s, partIdx, end)) {
                // add in list
                // since the substring method is upperbound exclusive,
                // we add a '+1' to amke the 'end' idx inclusive.
                sublist.add(s.substring(partIdx, end + 1));
                // explore
                recur(s, end + 1, sublist);

                // backtracking

                sublist.remove(sublist.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        n = s.length();
        recur(s, 0, new ArrayList<>());
        return res;
    }
}