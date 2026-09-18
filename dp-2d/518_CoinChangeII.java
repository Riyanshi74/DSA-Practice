// LeetCode 518: Coin Change II
// Link: https://leetcode.com/problems/coin-change-ii/
// Approach: Unbounded knapsack counting DP — dp[i][j] = number of ways to
// make amount j using the first i coin types (each coin type reusable any
// number of times, hence "take" recurses on dp[i][...] not dp[i-1][...]).
// Base case: dp[i][0] = 1 (one way to make 0 — take nothing), dp[0][j] = 0
// for j > 0 (no coins available, can't make a positive amount).
// Time: O(n * amount), Space: O(n * amount)

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1]; //ab yha dp value m no of coins ki jgh no of ways store honge
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=1;//amt 0 ko achieve krne ka ek hee tareeka h that is nit taking anything
        }
        for(int j=1;j<=amount;j++)
        {
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                int nottake = dp[i-1][j];
                int take =0;
                if(coins[i-1]<=j)
                {
                    take = take+dp[i][j-coins[i-1]];
                }
                dp[i][j]=take+nottake;
            }
        }
        return dp[n][amount];
    }
}