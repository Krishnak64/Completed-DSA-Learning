class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int count = 0;
        
        Arrays.sort(people);
        int i = 0;
        int j = n - 1;

        while(i <= j) {
            if(people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            count++;
        }
        
        return count;
    }
}