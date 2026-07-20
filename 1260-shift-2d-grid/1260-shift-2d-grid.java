class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int total = m * n;
        k %= total;

        Integer[][] ans = new Integer[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int idx = i * n + j;
                int nxt = (idx + k) % total;

                ans[nxt / n][nxt % n] = grid[i][j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (Integer[] row : ans)
            res.add(Arrays.asList(row));

        return res;
    }
}