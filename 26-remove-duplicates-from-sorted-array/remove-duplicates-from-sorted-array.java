class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // slow pointer - last unique element ka index
        for (int j = 1; j < nums.length; j++) { // fast pointer
            if (nums[j]!= nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}