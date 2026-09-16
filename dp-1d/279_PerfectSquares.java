class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0] = 0;
        dp[1] = 1;
        if(n==1)
        {
            return dp[1];
        }
        dp[2] = 2;
        if(n==2)
        {
            return dp[2];
        }
        dp[3] = 3;
        for(int i=4;i<=n;i++)
        {
            int j=2;
            while(true)
            {
                int sq = j*j;
                if(sq>i)
                {
                    break;
                }
                dp[i] = Math.min(1+dp[i-sq],dp[i]);
                j++;
            }
        }
        return dp[n];
    }
}