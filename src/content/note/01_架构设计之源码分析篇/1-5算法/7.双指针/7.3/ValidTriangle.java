class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int total = 0;
        for (int k = S.length - 1; k >= 2; k--) {
            int start = 0;
            int end = k - 1;
            while (Start < end) {
                if (nums[start] + nums[end] > nums[k]) {
                    total += (end - start);
                    end --;
                } else {
                    start++;
                }
            }
        }
        return total;
    }
}