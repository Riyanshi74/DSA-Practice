class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max =0;
        for(int i=0;i<n;i++)
        {
            StringBuilder sb = new StringBuilder();
            int len =0;
            for(int j=i;j<n;j++) //phle saare substrings evaluate kr rhe h one by one
            {
                if(sb.indexOf(String.valueOf(s.charAt(j)))==-1) //checking for repeating characters...agr unique hai then it will go inside this if condition
                {
                    sb.append(s.charAt(j));
                    max = Math.max(max,sb.length());
                }
                else   //else the loop will break jaise hee repeat honge
                {
                    break;
                }
            }
        }
        return max;
    }
}