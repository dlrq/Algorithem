public class PartitionArrayForMaximumSum {
    public static void main(String[] args){
        PartitionArrayForMaximumSum p = new PartitionArrayForMaximumSum();
        System.out.println(p.maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));
    }

    public int maxSumAfterPartitioningMemorize2d(int[] arr, int k) {
        int[][] memo = new int[arr.length][k];
        for(int i = 0;i < arr.length;i++){
            for (int j = 0;j < k;j++){
                memo[i][j] = -1;
            }
        }
        return helperMemo2d(arr, k, 0, memo);
    }

    public int helperMemo2d(int[] arr, int k, int l, int[][] memo){
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
                int max1 =  memo[l][i];
                for(int x = 0;x < k;x++){
                    max1 = Math.max(max1, memo[l][x]);
                }
                return max1;
            }
            max = Math.max(arr[l + i], max);
            res = Math.max(max * (i + 1) + helperMemo2d(arr, k, l + i + 1, memo), res);
            memo[l][i] = res;
        }

        return res;
    }

    public int maxSumAfterPartitioningMemorize1d(int[] arr, int k) {
        int[] memo = new int[arr.length];
        for(int i = 0;i < arr.length;i++){
                memo[i] = -1;
        }
        return helper(arr, k, 0, memo);
    }

    public int helper(int[] arr, int k, int l, int[] memo){
        if(l >= arr.length){
            return 0;
        }

        if(memo[l] != -1){
            return memo[l];
        }

        int res = 0;
        int max = arr[l];
        int i = 0;
        for(;i < k;i++){
            
            if(l + i >= arr.length){
                break;
            }

            max = Math.max(arr[l + i], max);
            res = Math.max(max * (i + 1) + helper(arr, k, l + i + 1, memo), res);
        }
        memo[l] = Math.max(memo[l], res);
        return res;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] memo = new int[n + 1];
        memo[0] = 0;
    
        for(int l = 1 ; l <= n ; l++){
            int max = -1;
            int res = -1;
            for(int i = 1;i <= k; i++){
                if(l - i >= 0){
                    max = Math.max(max, arr[l - i]);
                    res = Math.max(res, max * i + memo[l - i]);
                }
            }
            memo[l] = res;
        }

        return memo[n];
    }
}
