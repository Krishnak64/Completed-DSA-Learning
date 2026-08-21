class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circleSand = 0;
        int squreSand = 0;

        for(int std : students) {
            if(std == 0) {
                circleSand++;
            } else {
                squreSand++;
            }
        }

        for(int sand : sandwiches){
            if(sand == 0 && circleSand == 0) {
                return squreSand;
            }
           if(sand == 1 && squreSand == 0) {
                return circleSand;
            } 

            if(sand == 1) {
                squreSand--;
            }
            else {
                circleSand--;
            }
        }

        return 0;
    }
}