public class HouseRobber {
    public static void main(String[] args){

    }

    public static int rob(int[] nums){
        int[] res = new int[nums.length + 1];
        res[1] = nums[0];
        for (int i = 2 ; i < res.length; i++){
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i - 1]);
        }
        return res[nums.length];
    }

    public static int robBest(int[] nums){
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
}
