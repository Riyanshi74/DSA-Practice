// LeetCode 120: Triangle
// Link: https://leetcode.com/problems/triangle/
// Approach: Bottom-up grid DP. Copy triangle into a 2D array, fill dp[][]
// starting from the last row (base case: dp[last][j] = triangle value itself,
// since there's nowhere left to go). Then work upward — dp[i][j] = current
// value + min(path going straight down, path going diagonally down-right).
// Answer sits at dp[0][0] since we've propagated the minimum all the way up.
// Time: O(n^2), Space: O(n^2) (can be optimized to O(n) with a 1D array)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        int arr[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            List<Integer> neigh = triangle.get(i);
            for(int j=0;j<neigh.size();j++)
            {
                arr[i][j] = neigh.get(j);
            }
        }
        //basecase: last row fill kardo directly
        for(int j=0;j<n;j++)
        {
            dp[n-1][j]=arr[n-1][j];
        }
        //start from secodn last row to top
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = arr[i][j] + dp[i+1][j];
                int diagonal = arr[i][j] + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }
}