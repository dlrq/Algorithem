import java.util.Arrays;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1){
            return 1;
        }

        int[] res = new int[nums.length];
        res[0] = Integer.MAX_VALUE;
        int low = 0;
        int high = 1;
        for(int num : nums){
            int pos = Arrays.binarySearch(res, low, high, num);
            if(pos < 0){
                pos = -pos - 1;
            }
            res[pos] = num;
            if(pos == high){
                high++;
            }
        }
        return high;
    }
}
// @lc code=end

