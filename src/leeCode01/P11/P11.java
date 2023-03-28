package leeCode01.P11;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 返回容器可以储存的最大水量。
 * 
 * 说明：你不能倾斜容器。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P11 {
    public static void main(String[] args) {

        int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        // int[] height = new int[] { 1, 1 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (right > left) {
            int iHeight = Math.min(height[left], height[right]);
            int tempMaxArea = (right - left) * iHeight;
            if (tempMaxArea > maxArea) {
                maxArea = tempMaxArea;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    // public static int maxArea(int[] height) {
    // int maxArea = 0;
    // int maxX = 0;
    // int maxY = 0;
    // for (int i = 0; i <= height.length; i++) {
    // for (int j = height.length - 1; j > i; j--) {
    // int iHeight = Math.min(height[i], height[j]);
    // if ((j - i) <= maxX && (iHeight < maxY)) {
    // continue;
    // }

    // if ((j - i) * iHeight > maxArea) {
    // maxArea = (j - i) * iHeight;
    // maxX = (j - i);
    // maxY = iHeight;
    // }
    // }
    // }

    // return maxArea;
    // }

}