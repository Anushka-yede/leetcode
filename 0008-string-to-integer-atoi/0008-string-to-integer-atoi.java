class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        long ans = 0;

        // Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            ans = ans * 10 + (s.charAt(i) - '0');

            // Overflow check
            if (sign * ans >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign * ans <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int)(sign * ans);
    }
}