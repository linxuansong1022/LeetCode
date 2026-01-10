class Solution {
    public int maxVowels(String S, int k) {
        char[] s = S.toCharArray();
        int ans = 0;
        int vowel = 0;
        for (int i = 0; i < s.length; i++) { // 枚举窗口右端点 i
            // 1. 右端点进入窗口
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                vowel++;
            }

            int left = i - k + 1; // 窗口左端点
            if (left < 0) { // 窗口大小不足 k，尚未形成第一个窗口
                continue;
            }

            // 2. 更新答案
            ans = Math.max(ans, vowel);

            // 3. 左端点离开窗口，为下一个循环做准备
            char out = s[left];
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                vowel--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxVowels("abciiidef", 3)); // Expected: 3
        System.out.println(solution.maxVowels("aeiou", 2));     // Expected: 2
        System.out.println(solution.maxVowels("leetcode", 3));  // Expected: 2
    }
}
