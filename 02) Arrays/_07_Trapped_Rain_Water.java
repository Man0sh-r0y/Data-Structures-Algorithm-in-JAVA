
public class _07_Trapped_Rain_Water {

    public static int trappedWater(int height[]) {
        int n = height.length;
        int leftMax[] = new int[n];// left boundary
        int rightMax[] = new int[n];// right boundary
        // left max bkundary
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        // right max boundary
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        // trapped rain water
        int trappedRainWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedRainWater += waterLevel - height[i];
        }
        return trappedRainWater;
    }

    public static void main(String args[]) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(trappedWater(height));
    }
}
