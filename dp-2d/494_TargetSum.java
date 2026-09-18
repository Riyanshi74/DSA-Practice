// LeetCode 494: Target Sum
// Link: https://leetcode.com/problems/target-sum/
// Approach: Reduces to subset-sum DP. Split nums into a "positive" subset P
// and "negative" subset N such that sum(P) - sum(N) = target and
// sum(P) + sum(N) = totalSum. Adding these: sum(P) = (target + totalSum)/2.
// So the problem becomes "count subsets with sum = newt" via 0/1 knapsack
// counting DP. Special handling for nums[0]==0 (contributes 2 ways: +0/-0).
// Time: O(n * newt), Space: O(n * newt)

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int s=0;
        for(int i=0;i<n;i++)
        {
            s=s+nums[i];
        } 
        int newt = (target+s)/2;  //sum(P) - sum(N) = target and sum(P) + sum(N) = totalSum (let's call it s). Adding these two equations together:
        //(sum(P) - sum(N)) + (sum(P) + sum(N)) = target + s
        //sum(P) = (target + s) / 2
        if (Math.abs(target) > s)  // If target is outside the possible range, answer is 0.
        {
            return 0; 
        }
         //  (target + sum) must be even, otherwise subset sum won't be an integer.
        if ((target + s) % 2 != 0)
        {
            return 0;
        }
        //Handles cases where new target becomes negative.
        if (newt < 0) {
            return 0;
        }
        int dp[][] = new int[n][newt+1];
         // Base Case
        //If first element is 0, we have two choices (+0 and -0),
        // so there are 2 ways to make sum 0.
        if(nums[0]==0)
        {
            dp[0][0]=2;
        }
        else
        {
            dp[0][0]=1;
        }
        /*for(int i=1;i<n;i++)
        {
            dp[i][0]=1;
        }*/
        for(int j=1;j<=newt;j++)
        {
            if(nums[0]==j)
            {
                dp[0][j]=1;
            }
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=newt;j++) //j=0 base case ya hardcode krne ki jgh 
            {
                int nottake = dp[i-1][j];
                int take = 0;
                if(nums[i]<=j)
                {
                    take = dp[i-1][j-nums[i]]; //target sum m ek value ek hee baar use hogi
                }
                dp[i][j]=take+nottake;
            }
        }
        return dp[n-1][newt];
    }
}