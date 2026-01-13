import java.util.*;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            // 计算当前面积
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;
            
            // 更新最大面积
            maxArea = Math.max(maxArea, currentArea);
            
            // 移动较短的那根柱子
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }

    // --- ACM 模式：支持手动输入 ---
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("请输入数组长度:");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] height = new int[n];
            
            System.out.println("请输入 " + n + " 个高度值 (空格分隔):");
            for (int i = 0; i < n; i++) {
                if (sc.hasNextInt()) {
                    height[i] = sc.nextInt();
                }
            }
            
            ContainerWithMostWater sol = new ContainerWithMostWater();
            int result = sol.maxArea(height);
            
            System.out.println("最大盛水量为:");
            System.out.println(result);
        }
        sc.close();
    }
}