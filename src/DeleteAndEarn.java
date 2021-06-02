import java.util.*;

public class DeleteAndEarn {
    public static void main(String[] args) {
        //System.out.println(deleteAndEarnRecursive(new int[]{3,7,10,5,2,4,8,9,9,4,9,2,6,4,6,5,4,7,6,10}));
        System.out.println(deleteAndEarn(new int[]{3, 7, 10, 5, 2, 4, 8, 9, 9, 4, 9, 2, 6, 4, 6, 5, 4, 7, 6, 10}));
    }


    /**
     * 先分组求和，再按照key排序，最后动态规划求解
     * @param nums
     * @return
     */
    public static int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + n);
            } else {
                map.put(n, n);
            }
        }
        
        if (map.size() == 1) {
            return map.get(map.firstKey());
        }

        int[] keys = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()) {
            keys[i] = key;
            i++;
        }

        int[] res = new int[map.size()];
        res[0] = map.get(keys[0]);
        res[1] = keys[1] - keys[0] > 1 ? res[0] + map.get(keys[1]) : Math.max(res[0], map.get(keys[1]));
        map.remove(map.firstKey());
        map.remove(map.firstKey());
        i = 2;
        for (int key : map.keySet()) {
            res[i] = keys[i] - keys[i - 1] > 1 ? res[i - 1] + map.get(key) : Math.max(res[i - 1], res[i - 2] + map.get(key));
            i++;
        }
        return res[res.length - 1];
    }

    /**
     * 简化版，上面使用treemap保证有序成本很高，可以使用数组替换
     * @param nums
     * @return
     */
    public static int deleteAndEarnFast(int[] nums){
        int[] res = new int[10001];
        //求出最大值，缩小遍历的范围
        int max = 0;

        for(int num : nums){
            res[num] += num;
            max = Math.max(max, num);
        }

        for(int i = 2 ; i <= max; i++){
            res[i] = Math.max(res[i - 1], res[i] + res[i - 2]);
        }

        return res[max];
    }

    // 递归版
    public static int deleteAndEarnRecursive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int[] sub = new int[nums.length];
            int newLength = 0;
            for (int j = 0; j < nums.length; j++) {
                int n = nums[j];
                if (i != j && n != num + 1 && n != num - 1) {
                    sub[newLength] = n;
                    newLength++;
                }
            }
            int sum = num + deleteAndEarnRecursive(Arrays.copyOf(sub, newLength));
            if (sum > max) max = sum;
        }
        return max;
    }
}
