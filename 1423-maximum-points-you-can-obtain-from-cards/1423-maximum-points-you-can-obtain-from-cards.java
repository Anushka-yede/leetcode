class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int leftsum = 0;

        
        for (int i = 0; i < k; i++)
            leftsum += cardPoints[i];

        int max = leftsum;

        int right = n - 1;

        int rightsum = 0;
        for (int left = k - 1; left >= 0; left--) {

            leftsum -= cardPoints[left];
            rightsum += cardPoints[right];

            max = Math.max(max, leftsum + rightsum);

            right--;
        }

        return max;
    }
}