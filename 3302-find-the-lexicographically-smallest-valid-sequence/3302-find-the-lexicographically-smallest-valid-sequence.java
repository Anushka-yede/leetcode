class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // last[j] = latest index in word1 where word2[j]
        // can be matched while still matching word2[j+1...]
        int[] last = new int[m];

        for (int i = 0; i < m; i++) {
            last[i] = -1;
        }

        int i = n - 1;
        int j = m - 1;

        // Build the latest possible positions from right to left
        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        int[] ans = new int[m];

        j = 0;

        // Whether we have already used the one allowed mismatch
        boolean usedChange = false;

        for (i = 0; i < n && j < m; i++) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;
            }

            // Use our one allowed modification
            else if (!usedChange) {

                /*
                 * We can use i as the mismatching character if:
                 *
                 * 1. This is the last character of word2, OR
                 *
                 * 2. word2[j + 1...] can still be matched after i.
                 *
                 * last[j + 1] gives the latest possible position
                 * for word2[j + 1].
                 *
                 * Therefore i must be before last[j + 1].
                 */
                if (j == m - 1 || i < last[j + 1]) {

                    ans[j] = i;
                    j++;
                    usedChange = true;
                }
            }
        }

        // Could not form the complete sequence
        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}