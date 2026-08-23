// LeetCode 1927: Sum Game
// Link: https://leetcode.com/problems/sum-game/
// Approach: Split string into two halves, track known-digit sum and '?'
// count per half. If total '?' count is odd, Alice wins automatically (she
// places the last digit). If even, Bob can pair up same-half '?'s and force
// each pair to sum to 9. Bob wins only if this forced adjustment exactly
// cancels the SIGNED initial sum gap: (sum1-sum2) == 9*(cnt2-cnt1)/2.
// Using Math.abs() on both sides is WRONG — it loses direction and gives
// false positives/negatives. Otherwise Alice wins.
// Time: O(n), Space: O(1)
class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int cnt1 = 0;
        int cnt2 = 0;
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<n/2;i++)
        {
            char c = num.charAt(i);
            if(c=='?')
            {
                cnt1++;
            }
            else
            {
                sum1 = sum1 + Integer.parseInt(String.valueOf(c));
            }
        }
        for(int i=n/2;i<n;i++)
        {
            char c = num.charAt(i);
            if(c=='?')
            {
                cnt2++;
            }
            else
            {
                sum2 = sum2 + Integer.parseInt(String.valueOf(c));
            }
        }
        if((cnt1+cnt2)%2!=0) //If the combined count of question marks across both halves is odd, Alice automatically wins because with an odd total, Alice places the very last ?, giving her the final say on breaking any balance. 
        {
            return true;
        }
        if(sum1-sum2==9*(cnt2-cnt1)/2) //If the total is even, Bob wins only if the initial known-sum difference exactly equals 9 times half the difference in question-mark-counts between the two halves — otherwise Alice wins.
        {
            return false;
        }
        return true;
    }
}