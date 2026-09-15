// LeetCode 64: Minimum Path Sum
// Link: https://leetcode.com/problems/minimum-path-sum/
// Approach: Grid DP - dp[i][j] = minimum cost to reach cell (i,j) from (0,0).
// At each cell, add grid[i][j] to the smaller of the cost coming from above
// or from the left. Boundary cells (i==0 or j==0) rely on Integer.MAX_VALUE
// for the missing direction so Math.min correctly picks the only valid path.
// Time: O(n*m), Space: O(n*m)

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=grid[i][j];
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i>0)
                {
                    up=dp[i-1][j];
                }
                if(j>0)
                {
                    left=dp[i][j-1];
                }
                dp[i][j]=grid[i][j]+Math.min(up,left);
            }
        }
        return dp[n-1][m-1];
    }
}