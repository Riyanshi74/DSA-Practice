class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        int start =-1;
        int end =-1;
        int i=0;
        HashMap<String,String> map = new HashMap<>();
        for(List<String>pair:knowledge)
        {
            map.put(pair.get(0),pair.get(1));
        }
        StringBuilder sb = new StringBuilder();
        while(i<n)
        {
            if(s.charAt(i)=='(')
            {
                start = i+1;
                while(s.charAt(i)!=')')
                {
                    i++;
                }
                end = i;
                String sub = s.substring(start,end);
                
                if(map.containsKey(sub))
                {
                    String rep = map.get(sub);
                    sb.append(rep);
                }
                else
                {
                    sb.append('?');
                }
            }
            else
            {
                sb.append(s.charAt(i));
            }
            i++;
            
        }
        return sb.toString();
    }
}