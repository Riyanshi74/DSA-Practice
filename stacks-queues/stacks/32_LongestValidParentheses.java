class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int cnt = 0;
        Stack<Integer> st = new Stack<>();
        int maxlen =0;
        st.push(-1); //initially there is an imaginary partner
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(c=='(')
            {
                st.push(i);
            }
            else
            {
                if(st.size()!=0)
                {
                    st.pop();
                    if(st.size()!=0)
                    {
                        int top = st.peek();
                        maxlen = Math.max(maxlen,i-top);//Pop ke pehle ka top = wo ( jo abhi match ho gaya, to wo valid stretch ka hissa hai, boundary nahi.
                        //Pop ke baad ka top = wo pehla element jo match nahi hua, to wahi hamara boundary hai. Boundary ke baad se i tak sab valid.
                    }
                    else
                    {
                        st.push(i);//this becomes the new boundary or start agr iska partner ni mila toh
                    }
                }
            }
        }
        return maxlen;
    }
}