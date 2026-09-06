class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int res[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            if(map.containsKey(target - numbers[i])) {
                res[0] = map.get(target - numbers[i]) + 1;
                res[1] = i+1;
                return res;
            } else {
                map.put(numbers[i] , i);
            }
        }

        return res;
    }
}