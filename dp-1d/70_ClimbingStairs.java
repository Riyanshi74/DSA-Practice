// LeetCode 70: Climbing Stairs
// Link: https://leetcode.com/problems/climbing-stairs/
// Time: O(n), Space: O(1) if optimized to two variables, O(n) if using a full dp array
class Solution {
    public int climbStairs(int n) {
        //this is basically fibonacci sequence with base case f(1) = 1 and f(2) =2
        if(n==1)
        {
            return n;
        }
        if(n==2)
        {
            return n;
        }
        int a =1;
        int b=2;
        for(int i=3;i<=n;i++)
        {
            int c = a+b;
            a=b;
            b=c;
        }
        return b;
    }
}