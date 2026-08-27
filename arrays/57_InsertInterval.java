// LeetCode 57: Insert Interval
// Link: https://leetcode.com/problems/insert-interval/
// Approach: 3-pass greedy. First, add all intervals that end before the new
// interval starts (no overlap, no merge needed). Then, merge all intervals
// that overlap with newInterval by expanding start/end to the min/max seen.
// Finally, add all remaining intervals that start after newInterval ends.
// Time: O(n), Space: O(n) for the result list

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int start = newInterval[0];
        int end = newInterval[1];
        int i=0;
        List<int[]>res = new ArrayList<>();
        while(i<n && intervals[i][1]<start) //existing intervals that end before the new interval starts..unko merge krne ki need ni
        {
            res.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=end)
        {
            start = Math.min(start,intervals[i][0]);
            end = Math.max(end,intervals[i][1]);
            i++;
        }
        res.add(new int[]{start,end});
        //remaining intervals that start after this newinterval ends
        while(i<n)
        {
            res.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }
        return res.toArray(new int[res.size()][]); 
        //result.size() → outer array ka size kitna hoga (jitne intervals hain result mein)
        /*[] (khali) → inner dimension ko Java khud decide karega, kyunki har int[] ka size alag ho sakta hai (well yaha hamesha 2 hoga, but Java ko explicitly nahi bataya)
        Socho aise: tu bol rahi hai "mujhe result.size() rows ka ek 2D int array bana do, phir usmein apni saari values daal do."*/
    }
}