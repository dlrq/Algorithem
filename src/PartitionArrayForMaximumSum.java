public class PartitionArrayForMaximumSum {
    public static void main(String[] args){
        PartitionArrayForMaximumSum p = new PartitionArrayForMaximumSum();
        System.out.println(p.maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[][] memo = new int[arr.length][k];
        for(int i = 0;i < arr.length;i++){
            for (int j = 0;j < k;j++){
                memo[i][j] = -1;
            }
        }
        return helper(arr, k, 0, memo);
    }

    public int helper(int[] arr, int k, int l, int[][] memo){
        if(l >= arr.length){
            return 0;
        }

        int res = 0;
        int max = arr[l];
        int i = 0;
        for(;i < k;i++){
            
            if(l + i >= arr.length){
                break;
            }

            if(memo[l][i] != -1){
                return memo[l][i];
            }
            max = Math.max(arr[l + i], max);
            res = Math.max(max * (i + 1) + helper(arr, k, l + i + 1, memo), res);
            memo[l][i] = res;
        }

        return res;
    }
}
