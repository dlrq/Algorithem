

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            int h = Math.min(height[i], height[j]);
            max = Math.max(max, h * (j - i));
            while (height[i] <= h && i < j) i++;
            while (height[j] <= h && i < j) j--;
        }
        return max;
    }
}
