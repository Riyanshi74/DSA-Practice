// LeetCode 877: Stone Game
// Link: https://leetcode.com/problems/stone-game/
/*think in terms of "score difference", not absolute score
Har state pe hum track karte hain: agar dono players optimally khelein is sub-row (i se j tak) pe, toh current player apne score minus opponent ke score mein kitna aage rahega?
Define: dp[i][j] = maximum score difference (current turn wale player ke perspective se) jab sirf piles[i..j] bache hon.
Transition: current player ke paas 2 choices hain:
Left end (piles[i]) utha le → tab uska gain hai piles[i], minus jo bhi remaining game (i+1..j) mein opponent ka best advantage hoga (kyunki ab woh doosra player hai jo apna turn khel raha hai, uska optimal dp[i+1][j] hoga — jo humare liye "loss" hai, isliye minus).
Right end (piles[j]) utha le → similarly, piles[j] - dp[i][j-1].*/
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            dp[i][i]=piles[i];
        }
        for(int len=2;len<=n;len++)
        {
            for(int i=0;i+len-1<n;i++)
            {
                int j=i+len-1;
                dp[i][j]=Math.max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
            }
        }
        if(dp[0][n-1]>0)
        {
            return true;
        }
        return false;
    }
}