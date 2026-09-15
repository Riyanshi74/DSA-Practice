// LeetCode 62: Unique Paths
// Link: https://leetcode.com/problems/unique-paths/
// Time: O(n*m), Space: O(n*m)

//express....here we will express it in terms of i and j kyuki 2d matrix h
//explore..find the base case and check how u can explore all the paths...idhr base case will be i=0 and j=0 where the function will return 1 and another will be i<0 and j<0 where the function will return 0 kyuki path boundary ke bhr ja chuka hai...we cant include it anymore...or ye base cases humare isiliye bne hai because instead of starting from 0,0 we started from n-1,m-1 and traverses till 0,0
//sum up the paths of up and left 
class Solution {
    public int uniquePaths(int m, int n) {
       int dp[][] = new int[n][m];
       for(int i=0;i<n;i++)
       {
        for(int j=0;j<m;j++)
        {
            if(i==0 && j==0)
            {
                dp[i][j]=1;
            }
            else
            {
                int up=0;
                int left =0;
                if(i>0)
                up=dp[i-1][j];
                if(j>0)
                left =dp[i][j-1];
                dp[i][j]=up+left;
            }
        }
       }
       return dp[n-1][m-1];
    }
}