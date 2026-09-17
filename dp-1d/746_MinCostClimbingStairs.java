// LeetCode 746: Min Cost Climbing Stairs
// Link: https://leetcode.com/problems/min-cost-climbing-stairs/
// Approach: DP — dp[i] = minimum cost to REACH step i (not pay for it).
// You can start from step 0 or step 1 for free (dp[0]=dp[1]=0). For any
// step i, you arrive either from step i-1 (paying cost[i-1]) or step i-2
// (paying cost[i-2]) — take whichever is cheaper. Since you can step off
// the top from either the last or second-last stair, dp[n] gives the answer.
// Time: O(n), Space: O(n) (can be optimized to O(1) with 2 rolling variables)

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1]; //since we have to find the topmost ans
        dp[0] = 0; //no cost to reach step 0
        dp[1] = 0; //no cost to reach step 1
        for(int i=2;i<=n;i++)
        {
            //you can reach step i either from step i-1 or i-2...you hv to take the min of either
            dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }
        return dp[n];
    }
}