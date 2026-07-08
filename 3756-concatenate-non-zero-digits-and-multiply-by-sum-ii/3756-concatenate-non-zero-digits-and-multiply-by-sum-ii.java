import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        // Store all non-zero digits and their positions
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                digits.add(d);
                pos.add(i);
            }
        }

        int m = digits.size();

        // Powers of 10 modulo MOD
        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Prefix concatenated number and prefix digit sum
        long[] prefNum = new long[m + 1];
        long[] prefSum = new long[m + 1];

        for (int i = 0; i < m; i++) {
            prefNum[i + 1] = (prefNum[i] * 10 + digits.get(i)) % MOD;
            prefSum[i + 1] = prefSum[i] + digits.get(i);
        }

        // first[i] = first non-zero digit index >= i
        int[] first = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            while (idx < m && pos.get(idx) < i) idx++;
            first[i] = idx;
        }

        // last[i] = last non-zero digit index <= i
        int[] last = new int[n];
        idx = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (idx >= 0 && pos.get(idx) > i) idx--;
            last[i] = idx;
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {

            int l = queries[k][0];
            int r = queries[k][1];

            int L = first[l];
            int R = last[r];

            if (L >= m || R < 0 || L > R) {
                ans[k] = 0;
                continue;
            }

            int len = R - L + 1;

            long x = (prefNum[R + 1]
                    - (prefNum[L] * pow10[len]) % MOD
                    + MOD) % MOD;

            long sum = prefSum[R + 1] - prefSum[L];

            ans[k] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}