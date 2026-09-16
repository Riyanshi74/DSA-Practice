class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n]; //dp[i] = 5 would mean "the longest increasing subsequence that ends with nums[i] as its last element has length 5"
        Arrays.fill(dp,1); //every element is itself a subsequence so min length that each one will have will be 1
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i]) //elements appearing before i should be smaller
                {
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        int ans =0;
        for(int i=0;i<n;i++)
        {
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}