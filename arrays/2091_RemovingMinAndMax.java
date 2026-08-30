// LeetCode 2091: Removing Minimum and Maximum From Array
// Link: https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
// Approach: Find the index of the min element and the max element. To
// remove both, you can only ever remove from the front or the back of the
// array (one element at a time). So there are exactly 3 possible strategies:
// 1) Remove everything up to and including the later of the two indices from
//    the front, 2) Remove everything from the earlier index to the end from
//    the back, 3) Remove one from the front (up to the earlier index) and
//    the rest from the back (from the later index onward). Take the min of
//    all 3 options.
// Time: O(n), Space: O(1)

class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int maxi =0;
        int mini= 0;
        int maxval = nums[0];
        int minval=nums[0];
        for(int i=1;i<n;i++)
        {
            if(nums[i]<minval)
            {
                mini = i;
                minval=nums[i];
            }
            if(nums[i]>maxval)
            {
                maxval = nums[i];
                maxi = i;
            }
        }
        int i = Math.min(mini, maxi);
        int j = Math.max(mini, maxi);
        int option1 = j + 1;              // dono ko front se remove karo (0..j tak sab hata do)
        int option2 = n - i;               // dono ko back se remove karo (i..n-1 tak sab hata do)
        int option3 = (i + 1) + (n - j);   // ek front se (0..i), ek back se (j..n-1)
        return Math.min(option1, Math.min(option2, option3));
    }
}