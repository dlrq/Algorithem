import java.util.Arrays;

public class HouseRobberIII {
    public static void main(String[] args){
        int[] nums = new int[]{3,2,5,76,2,5,2,5};
        System.out.println(robBest(nums));
    }

    public static int robNotBest(int[] nums){
        boolean firstChosen = false;
        boolean lastChosen = false;
        int prepre = 0;
        int pre = nums[0];
        int res = pre;
        for (int i = 1 ; i < nums.length; i++){
            int a = prepre + nums[i];
            int b = pre;
            if(a > b){
                res = a;
                if(i == 2){
                    firstChosen = true;
                }
                if(i == nums.length - 1){
                    lastChosen = true;
                }
            }else if(b > a){
                res = b;
                if(i == 1){
                    firstChosen = true;
                }
            }else {

            }
            prepre = pre;
            pre = res;
        }

        if(firstChosen && lastChosen){
            return Math.max(rob0(Arrays.copyOfRange(nums, 0, nums.length - 1)), rob0(Arrays.copyOfRange(nums, 1, nums.length)));
        }
        return res;
    }

    public static int rob0(int[] nums){
        int prepre = 0;
        int pre = nums[0];
        int res = pre;
        for (int i = 1 ; i < nums.length; i++){
            res = Math.max(pre, prepre + nums[i]);
            prepre = pre;
            pre = res;
        }
        return res;
    }

    /**
     * 不可能同时选第一个和最后一个
     * @param nums
     * @return
     */
    public static int robBest(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public static int rob(int[] nums, int low, int high){
        int prepre = 0;
        int pre = nums[low];
        int res = pre;
        for (int i = low + 1 ; i < high; i++){
            res = Math.max(pre, prepre + nums[i]);
            prepre = pre;
            pre = res;
        }
        return res;
    }
}
