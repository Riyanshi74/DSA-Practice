//try to answer these questions and ull be able to build the code on ur own:
/*A _ _ A _ _ A

Question 1: Count the characters in that skeleton above (including blanks). In terms of f_max and n, what's the formula for this skeleton's length? (Think: how many "A + gap" blocks are there, and is the last one special?)

Question 2: Now suppose there's a tie — say B also has frequency 3. Where would you place the Bs in the skeleton above, and why does the number of tasks tied at max frequency matter for the final length?

Question 3: Once you've filled in every A and B into the skeleton, what if there are still empty _ slots left over — do other lower-frequency tasks fill them, or do they add extra idle time?

Question 4: Finally — this formula could sometimes come out smaller than tasks.length. When would that happen, and what should you do in that case?*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int t = tasks.length;
        int maxfre = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t;i++)
        {
            if(!map.containsKey(tasks[i]))
            {
                map.put(tasks[i],1);
            }
            else
            {
                map.put(tasks[i],map.get(tasks[i])+1);
            }
            int f = map.get(tasks[i]);
            if(f>maxfre)
            {
                maxfre=f;
            }
        }
        int cnt =0;
        for(char c:map.keySet())
        {
            int fre = map.get(c);
            if(fre==maxfre)
            {
                cnt++;//no of characters with maxfreq
            }
        }
        int res =0;
        int ans = n*(maxfre-1)+maxfre+(cnt-1);
        res = Math.max(t,ans); //aisa bhi hoga jab maxfre ke thru blnks calculate krne s jo ans h vo sb characters ko fit hee na kar paaye in that case we will take the total length as the ans
        return res;
    }
}