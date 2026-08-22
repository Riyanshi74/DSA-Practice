// LeetCode 2029: Stone Game IX
// Link: https://leetcode.com/problems/stone-game-ix/
// Approach: Only stones[i] % 3 matters. A player loses when their own
// cumulative sum of picked stones becomes divisible by 3. Remainder-0
// stones act as "free passes" that don't change danger level but consume
// a turn.
// - cnt0 even: passes cancel in pairs, Alice keeps first-mover edge on the
//   real game -> she wins iff both remainder-1 and remainder-2 stones exist.
// - cnt0 odd: one unpaired pass flips effective first-mover to Bob -> Alice
//   only wins if cnt1 and cnt2 are imbalanced by more than 2.
// Time: O(n), Space: O(1)

class Solution {
    public boolean stoneGameIX(int[] stones) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int s : stones) {
            int r = s % 3;
            if (r == 0) cnt0++;
            else if (r == 1) cnt1++;
            else cnt2++;
        }

        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        } else {
            return Math.abs(cnt1 - cnt2) > 2;
        }
    }
}