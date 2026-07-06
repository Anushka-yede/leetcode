class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sol = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            sol[i] = nums[i] * nums[i];

        }
        Arrays.sort(sol);
        return sol;
    }
}