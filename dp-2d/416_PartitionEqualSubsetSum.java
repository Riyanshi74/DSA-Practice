// LeetCode 416: Partition Equal Subset Sum
// Link: https://leetcode.com/problems/partition-equal-subset-sum/
// Approach: 0/1 Knapsack (subset-sum DP). Total sum ka half target maan lo.
// Agar hum ek subset find kar lete hain jiska sum = totalSum/2,
// toh automatically doosre subset ka sum bhi totalSum/2 hi hoga.
// Hence array can be partitioned into two equal subsets.
// dp[i][target] = Kya hum index 0 se i tak ke elements use karke
// 'target' sum bana sakte hain? Har element ke liye take/notTake choice.
// Time: O(n * sum), Space: O(n * sum)

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int s=0;
        for(int i=0;i<n;i++)
        {
            s=nums[i]+s;
        }
        if(s%2!=0)
        {
            return false;
        }
        boolean dp[][] = new boolean[n][(s/2)+1]; //dp state: 
        // dp[i][target] = Kya hum index 0 se i tak ke elements use karke
        // 'target' sum bana sakte hain?
        for(int i=0;i<n;i++)
        {
            dp[i][0] = true; //target 0 hogya h matlab jo sum chahiye tha wo mil chuka hai.
            // Isliye kisi bhi index par target = 0 => true.
        }
        if(nums[0] <= s/2) //otherwise idx out of bounds hoga...it wont even exist
        dp[0][nums[0]] = true; ///0th idx pr hai nd target is equal to number at 0th index
        //these are base cases
        // Fill DP table from left to right.
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=s/2;j++)
            {
                boolean nottake = dp[i-1][j];
                boolean take = false;// Har element ke liye 2 choices hain:
                //Not Take -> Current element ko ignore karo.
                //Take -> Agar current element target se chhota/equal hai,
                // toh ise include karke remaining target check karo.
                // Ye exactly recursion ke take/notTake logic ko DP me convert kiya hai.
                if(nums[i]<=j)
                {
                    take = dp[i-1][j-nums[i]];
                }
                dp[i][j] = nottake | take;
            }
        }
        return dp[n-1][s/2];
    }
}