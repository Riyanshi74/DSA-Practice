/*Ek depth counter rakho.
( aaye: depth++, phir ans[i] = depth % 2.
) aaye: pehle ans[i] = depth % 2, phir depth--*/
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int arr[] = new int[n];
        int depth =0;
        for(int i=0;i<n;i++)
        {
            char c = seq.charAt(i);
            if(c=='(')
            {
                depth++;
                int val = depth%2;
                if(val%2!=0) //odd..assign A set
                {
                    arr[i] =0;
                }
                else
                {
                    arr[i]=1;
                }
            }
            else if(c==')')
            {
                int val = depth%2;
                if(val%2!=0) //odd..assign A set
                {
                    arr[i] =0;
                }
                else
                {
                    arr[i]=1;
                }
                depth--;
            }
        }
        return arr;
    }
}