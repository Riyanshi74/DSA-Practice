//boat will atmost handle 2 people...so first sort the people and keep assigning heaaviest with the lg=ightest using 2 ptr
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int cnt =0;
        int curr =0;
        Arrays.sort(people);
        int l =0;
        int r = n-1;
        while(l<=r)
        {
            int tot = people[l]+people[r];
            if(tot<=limit) //if the boat cant handle 2 people then l++
            {
                l++;
            }
            cnt++; //1 boat will be occupied 
            r--;
        }
        return cnt;
    }
}