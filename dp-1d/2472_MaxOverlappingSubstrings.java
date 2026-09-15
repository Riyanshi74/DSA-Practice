//This is the key reframe: instead of thinking "what's the longest palindrome ending at i," think "for every center in the string, the smallest valid palindrome at that center is length k or k+1." Any decision you could make by picking a longer palindrome at that center, you could instead make by picking the smallest one at that center — and the smallest one:
/*still satisfies length ≥ k (valid),
takes up less space (its span [j, i-1] is a subset of the longer one's span),
so it leaves strictly more room on both sides for other picks.*/
class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int dp[] = new int[n+1]; //dp[i] = best answer considering the prefix s[0..i) — i.e., the first i characters (0-indexed, i is exclusive as an end bound).
        dp[0] = 0;
        for(int i=1;i<=n;i++)
        {
            dp[i]=dp[i-1];
            for(int len = k;len<=k+1;len++)
            {
                int j = i-len;
                if(j>=0 && check(s,i,j))
                {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp[n];
    }
    public boolean check(String s,int end,int start)
    {
        String str = s.substring(start,end);
        int n = str.length();
        int l = 0;
        int r = n-1;
        while(l<r)
        {
            if(str.charAt(l)!=str.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}