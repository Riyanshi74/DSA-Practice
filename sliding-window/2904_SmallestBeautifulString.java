/*
 * LeetCode 2904: Shortest and Lexicographically Smallest Beautiful String
 * Link: https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string
 Time Complexity: O(n^2) worst case — due to substring() creating new strings
 *                   on every valid window (O(n) per creation, up to O(n) windows).
 *                   (Note: true window traversal itself is O(n) via two pointers,
 *                   but substring extraction dominates.)
 * Space Complexity: O(n) — for storing substrings (res, ans candidates)*/

//normal sliding window and 2 pointer waala concept use kia and then side by side string ko bhi store krna hai which has the minimum length 
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int l =0;
        int r=0;
        int ones =0;
        int len =Integer.MAX_VALUE;
        String res ="";
        while(l<=r && r<n)
        {
            char c = s.charAt(r);
            if(c=='1')
            {
                ones++;
            }
            while(ones>=k)
            {
                if(len>r-l+1)
                {
                    len = r-l+1;
                    res = s.substring(l,r+1);
                }
                if(len==r-l+1) //lexicographically smaller ko as res change krna h
                {
                    String ans = s.substring(l,r+1);
                    /*"abc".compareTo("abd")   // returns negative (abc < abd)
                    "abd".compareTo("abc")   // returns positive (abd > abc)
                    "abc".compareTo("abc")   // returns 0 (equal)*/
                    if(ans.compareTo(res)<0) 
                    {
                        res = ans;
                    }
                }
                if(s.charAt(l)=='1')
                {
                    ones--;
                }
                l++;//shrinking the window
            }
            r++;
        }
        return res;
    }
}