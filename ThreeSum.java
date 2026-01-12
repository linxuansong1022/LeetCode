import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        
        Arrays.sort(nums); // 1. 排序
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break; // 优化
            
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 2. 第一个数去重
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 3. 第二个数和第三个数去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    // --- ACM 模式：支持手动输入 ---
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("请输入数组长度:");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            
            System.out.println("请输入 " + n + " 个整数 (空格分隔):");
            for (int i = 0; i < n; i++) {
                if (sc.hasNextInt()) {
                    nums[i] = sc.nextInt();
                }
            }
            
            ThreeSum sol = new ThreeSum();
            List<List<Integer>> result = sol.threeSum(nums);
            
            System.out.println("符合条件的三元组:");
            System.out.println(result);
        }
        sc.close();
    }
}