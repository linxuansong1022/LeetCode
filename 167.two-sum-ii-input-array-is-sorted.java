/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */
import java.util.*;

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                // 题目要求下标从1开始
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    // ACM 模式输入输出入口
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. 读取数组长度
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] numbers = new int[n];
            
            // 2. 读取数组元素
            for (int i = 0; i < n; i++) {
                numbers[i] = sc.nextInt();
            }
            
            // 3. 读取目标值
            int target = sc.nextInt();
            
            // 4. 计算并输出结果
            Solution solution = new Solution();
            int[] result = solution.twoSum(numbers, target);
            System.out.println(Arrays.toString(result));
        }
        
        sc.close();
    }

}
// @lc code=end