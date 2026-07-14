class Solution {

    private static final int MOD = 1_000_000_007;

    int[] nums;
    int n;

    Integer[][][] dp;

    public int subsequencePairCount(int[] nums) {

        this.nums = nums;
        this.n = nums.length;

        dp = new Integer[n + 1][201][201];

        return dfs(0, 0, 0);
    }

    private int dfs(int index, int g1, int g2) {

        if (index == n) {
            if (g1 > 0 && g1 == g2)
                return 1;
            return 0;
        }

        if (dp[index][g1][g2] != null)
            return dp[index][g1][g2];

        long ans = 0;

        // Ignore current element
        ans += dfs(index + 1, g1, g2);

        // Put in first subsequence
        int newG1 = (g1 == 0) ? nums[index] : gcd(g1, nums[index]);
        ans += dfs(index + 1, newG1, g2);

        // Put in second subsequence
        int newG2 = (g2 == 0) ? nums[index] : gcd(g2, nums[index]);
        ans += dfs(index + 1, g1, newG2);

        ans %= MOD;

        return dp[index][g1][g2] = (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}