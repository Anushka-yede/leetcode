class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') ones++;
        }

        // Augment with 1 at both ends
        String t = "1" + s + "1";
        int m = t.length();

        int ans = ones;
        int i = 0;

        while (i < m) {
            if (t.charAt(i) == '0') {
                int z1 = 0;
                while (i < m && t.charAt(i) == '0') {
                    z1++;
                    i++;
                }

                int j = i;
                int onesBlock = 0;
                while (j < m && t.charAt(j) == '1') {
                    onesBlock++;
                    j++;
                }

                int k = j;
                int z2 = 0;
                while (k < m && t.charAt(k) == '0') {
                    z2++;
                    k++;
                }

                // valid pattern: 0...0 1...1 0...0
                if (onesBlock > 0 && z2 > 0) {
                    ans = Math.max(ans, ones + z1 + z2);
                }
            } else {
                i++;
            }
        }

        return Math.min(ans, n);
    }
}