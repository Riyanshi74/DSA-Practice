class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>res= new ArrayList<>();
        if(digits.length()==0)
        {
            return res;
        }
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(digits,0,new StringBuilder(),res,map);
        return res;
    }
    public void solve(String digit,int idx,StringBuilder curr,List<String>res,String[] map)
    {
        if(idx==digit.length()) //pura string is processed
        {
            res.add(curr.toString());
            return;
        }
        String l = map[digit.charAt(idx)-'0'];
        for(int i=0;i<l.length();i++)
        {
            char ch = l.charAt(i);
            curr.append(ch);
            solve(digit,idx + 1,curr,res,map);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}