// LeetCode 198: House Robber
// Link: https://leetcode.com/problems/house-robber/
// Approach: DP with 2 rolling variables — at each house, either skip it (take
// best till previous house) or rob it (best till 2 houses back + current value).
// a = best excluding previous house, b = best including previous house.
// curr = max(a, b + nums[i]) → new best so far.
// Time: O(n), Space: O(1)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
        {
            return nums[0];
        }
        if(n==2)
        {
            return Math.max(nums[0],nums[1]);
        }
        //a = best money you can rob using houses 0 to i-1 (i.e., up to and including the previous house)
        //b = best money you can rob using houses 0 to i-2 (i.e., up to two houses before the current one)
        int a =0;
        int b =0;
        int curr =0;
        for(int i=0;i<n;i++)
        {
            curr = nums[i];
            curr = Math.max(a,b+curr); //Skip house i → your best stays whatever it was up to the previous house → that's a
            //Rob house i → you can't have robbed the previous house (adjacent), so you add nums[i] to the best from two houses back → that's b + curr
            b = a;
            a = curr;
        }
        return curr;
    }
}