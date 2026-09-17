// LeetCode 91: Decode Ways
// Link: https://leetcode.com/problems/decode-ways/
// Approach: DP — dp[i] = number of ways to decode s[0..i]. At each index,
// check two possibilities: (1) treat s[i] as a single digit decode (valid
// if it's not '0'), contributing dp[i-1] ways, and (2) treat s[i-1..i] as a
// two-digit decode (valid if it forms a number 1-26 and prev isn't '0'),
// contributing dp[i-2] ways. Both can apply simultaneously (hence the third
// block adding them together) when both single and pair decodes are valid.
// Time: O(n), Space: O(n) (can be optimized to O(1) with 2 rolling variables)

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n];
        if(s.charAt(0)=='0')
        {
            return 0;
        }
        dp[0] = 1;//at 0 idx...the strinfg can be docded in 1 way only
        for(int i=1;i<n;i++)
        {
            char c = s.charAt(i);
            char prev = s.charAt(i-1);
            String str = s.substring(i-1,i+1);
            int val = Integer.parseInt(str);
            if(c!='0' )
            {
                dp[i]=dp[i-1];
            }
            if(val<=26 && val>0 && prev!='0') //if prev ==0 then its not a valid pair...vo single digit hee consider hoga and this block will be used only if its a valid pair
            {
                if(i-2>=0)
                {
                    dp[i]=dp[i-2];
                }
                else
                {
                    dp[i]=1;
                }
            }
            if(val<=26 && c!='0' && val>0 && prev!='0')
            {
                if(i-2>=0)
                {
                    dp[i] = dp[i-1]+dp[i-2];
                }
                else
                {
                    dp[i] = 1+dp[i-1];//empty string is there at i-2 and there is only 1 way to decode an empty string
                }
            }
        }
        return dp[n-1];
    }
}