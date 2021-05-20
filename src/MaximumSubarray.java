public class MaximumSubarray {
    public static void main(String[] args) {

    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = Integer.MIN_VALUE;
        for (int num : nums) {
            max_ending_here = Math.max(num, max_ending_here + num);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        return max_so_far;
    }
}
