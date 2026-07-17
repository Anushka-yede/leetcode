class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        int[] freq = new int[max + 1];

        for (int x : nums)
            freq[x]++;

        int[] cnt = new int[max + 1];

        for (int d = 1; d <= max; d++) {
            for (int m = d; m <= max; m += d) {
                cnt[d] += freq[m];
            }
        }

        long[] exact = new long[max + 1];

        for (int d = max; d >= 1; d--) {

            long pairs = (long) cnt[d] * (cnt[d] - 1) / 2;

            exact[d] = pairs;

            for (int m = d * 2; m <= max; m += d) {
                exact[d] -= exact[m];
            }
        }

        long[] prefix = new long[max + 1];

        for (int i = 1; i <= max; i++)
            prefix[i] = prefix[i - 1] + exact[i];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long q = queries[i];

            int l = 1, r = max;

            while (l < r) {

                int mid = l + (r - l) / 2;

                if (prefix[mid] > q)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[i] = l;
        }

        return ans;
    }
}