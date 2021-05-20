import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int[] res = new int[nums.length + 1];
        res[1] = 1;
        List<Integer> preMax = new ArrayList<>(nums.length);
        List<Integer> max = new ArrayList<>(nums.length);
        max.add(nums[0]);
        for(int i = 2 ; i < res.length ; i++){
            int maxLength = 0;
            int preMaxLength = 0;
            if(nums[i - 1] > max.get(max.size() - 1)){
                maxLength = res[i - 1] + 1;
                max = nums[i - 1];
            }else{
                maxLength = res[i - 1];
            }
            Arrays.binarySearch()

            //res[i] = Math.max();
        }

        return res[nums.length + 1];
    }

    public static void main(String[] args){

    }
}
