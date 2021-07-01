public class UniquePaths{
    public static void main(String[] args){
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7));
        System.out.println(uniquePaths.uniquePaths(1, 1));
        System.out.println(uniquePaths.uniquePaths(3, 2));
        System.out.println(uniquePaths.uniquePaths(7, 3));
        System.out.println(uniquePaths.uniquePaths(3, 3));
    }

    public int uniquePaths(int m, int n){
        int[] res = new int[n];
        for(int i = 0;i < m;i++)
            for(int j = 0;j < n;j++){
                if(i == 0 || j == 0){
                    res[j] = 1;
                }else{
                    res[j] = res[j - 1] + res[j];
                }
            }
        
        return res[n - 1];
    }
}