class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            int no = nums[i];
            if(map.containsKey(no)){
               map.put(no, map.get(no)+1);
            } else {
                map.put(no, 1);
            }
        }

        int[][] helper = new int[map.size()][2];

        int index = 0;

        for (int key : map.keySet()) {
            helper[index][0] = key;
            helper[index][1] = map.get(key);
            index++;
        }

        Arrays.sort(helper, (a, b) -> Integer.compare(a[1], b[1]));
        int[] ans = new int[k];

        for(int i=0; i<k; i++) {
            ans[i] = helper[map.size()-1-i][0];
        }

        return ans;

    }
}