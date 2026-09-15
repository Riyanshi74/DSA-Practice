class Solution {
    public boolean check(String s)
    {
        int n = s.length();
        int l =0;
        int r =n-1;
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int maxlen =0;
        int n = s.length();
        String ans = "";
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(check(s.substring(i,j+1)))
                {
                    int len = j-i+1;
                    if(len>maxlen)
                    {
                        ans = s.substring(i,j+1);
                        maxlen = len;
                    }
                }
            }
        }
        return ans;
    }
}