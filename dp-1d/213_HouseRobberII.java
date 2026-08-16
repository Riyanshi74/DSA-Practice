// LeetCode 213: House Robber II
// Link: https://leetcode.com/problems/house-robber-ii/
// Approach: Circular array — house 0 and house n-1 are adjacent, so they
// can't both be robbed. Break into 2 linear House Robber I subproblems:
// (a) rob houses [0, n-2], (b) rob houses [1, n-1]. Return the max of both.
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
        if(n==3)
        {
            return Math.max(nums[0],Math.max(nums[1],nums[2]));
        }
        int a =0;
        int b =0;
        int curr =0;
        for(int i=1;i<n;i++) //phle first waale ghr ko htaa kr calculate kro ans then last waale ko htakr...jisme bhi ,aximum hoga vo final ans hoga...kjyuki first or last dono saath m ni le skte
        {
            curr = nums[i];
            curr = Math.max(a,b+curr);
            b = a;
            a = curr;
        }
        a=0;
        b= 0;
        int cur=0;
        for(int i=0;i<n-1;i++)
        {
            cur = nums[i];
            cur = Math.max(a,b+cur);
            b = a;
            a = cur;
        }
        return Math.max(cur,curr);
    }
}