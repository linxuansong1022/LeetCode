/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */
import java.util.*;

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // ACM 模式：为了能在本地运行，我们在 Solution 类里放一个 main 方法
    // 注意：LeetCode 插件在 Submit 时通常会忽略 main 方法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = sc.nextInt();
            }
            Solution sol = new Solution();
            System.out.println(sol.maxArea(height));
        }
        sc.close();
    }
}
// @lc code=end
