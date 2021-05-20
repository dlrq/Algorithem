import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int now = nums[i];
            if (now > 0) break;
            for (int front = i + 1, end = nums.length - 1; front < end; ) {
                int sum = nums[front] + nums[end] + now;
                if (sum == 0) {
                    res.add(Arrays.asList(now, nums[front], nums[end]));
                    front++;
                    end--;
                    while (front < end && nums[front] == nums[front - 1]) front++;
                    while (front < end && nums[end] == nums[end + 1]) end--;
                } else if (sum > 0) {
                    end--;
                } else {
                    front++;
                }

            }
        }

        return res;
    }
}
