// LeetCode 419: Battleships in a Board
// Link: https://leetcode.com/problems/battleships-in-a-board/
// Approach: Since ships are guaranteed to be straight lines (horizontal or
// vertical) with at least one empty cell separating any two ships, we only
// need to count the "top-left" starting cell of each ship. For every 'X',
// check if the cell above OR to the left is also 'X' — if so, this cell is
// part of a ship already counted, so skip it. Otherwise, it's a new ship's
// starting cell, so increment count.
// Time: O(n*m), Space: O(1)

class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int cnt =0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='X')
                {
                    if(i>0 && board[i-1][j]=='X')
                    {
                        continue;
                    }
                    if(j>0 && board[i][j-1]=='X')
                    {
                        continue;
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }
}