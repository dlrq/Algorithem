import java.util.Arrays;

public class ThresSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        for(int i = 0;i < n - 2;i++){
            for(int j = i + 1,k = n - 1;j < k;){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) return sum;
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if(sum < target) j++;
                if(sum > target) k--;
            }
        }
        return res;
    }
}
