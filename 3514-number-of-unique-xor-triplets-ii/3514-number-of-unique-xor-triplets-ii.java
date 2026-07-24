class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[] present = new boolean[MAX];

        // Store distinct values
        for (int num : nums) {
            present[num] = true;
        }

        // List of distinct values
        int[] values = new int[nums.length];
        int m = 0;
        for (int i = 0; i < MAX; i++) {
            if (present[i]) {
                values[m++] = i;
            }
        }

        boolean[] two = new boolean[MAX];

        // XOR of any two picks
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                two[values[i] ^ values[j]] = true;
            }
        }

        boolean[] three = new boolean[MAX];

        // XOR of three picks
        for (int x = 0; x < MAX; x++) {
            if (!two[x]) continue;
            for (int i = 0; i < m; i++) {
                three[x ^ values[i]] = true;
            }
        }

        int ans = 0;
        for (boolean b : three) {
            if (b) ans++;
        }

        return ans;
    }
}