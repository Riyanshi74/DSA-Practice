class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(c=='('||c=='{' ||c=='[')
            {
                st.push(c);
            }
            else
            {
                if(!st.isEmpty())
                {
                    char r = st.peek();
                    if(c==')' && r=='(')
                    {
                        st.pop();
                    }
                    else if(c=='}' && r=='{')
                    {
                        st.pop();
                    }
                    else if(c==']' && r=='[')
                    {
                        st.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}