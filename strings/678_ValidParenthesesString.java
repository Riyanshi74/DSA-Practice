/*Analogy: socho tumhare paas ek jar hai jisme "open brackets" ki ginti hai — matlab abhi tak kitne ( hain jo close hone baaki hain. Normal parenthesis problem mein ye ek fixed number hota hai (ek hi jar). Lekin yahan, kyunki * multiple cheez ban sakta hai, tumhare paas do jars hain:

low = agar har * ko worst case (yaani jitna jaldi ho sake ) ya empty) treat karein, to minimum kitne open brackets bache honge
high = agar har * ko best case (yaani () treat karein, to maximum kitne open brackets ho sakte hain

Matlab low aur high ek range define karte hain: "abhi tak, open brackets ki count kahin bhi low se high ke beech ho sakti hai, depending on kaise tum * ko interpret karte ho."

Ab character-by-character socho:

( mila → ye pakka ek open bracket hai, koi ambiguity nahi. To low++ aur high++ (dono jars mein ek ( add ho gaya, guaranteed).
) mila → ye pakka ek open bracket ko close karega. To low-- aur high-- (dono jars se ek open bracket kam ho gaya, guaranteed).
* mila → yahan ambiguity hai:
Agar * ko ) maan lo (worst case for low) → low--
Agar * ko ( maan lo (best case for high) → high++
(agar empty maanein, low aur high dono same rahenge — but wo already low aur high ke range ke beech cover ho jata hai)*/
/*agar low kabhi negative ho jaye (matlab worst case mein zyada ) ho gaye ( se), iska matlab ye nahi ki poori string invalid hai — kyunki high abhi bhi valid ho sakta hai (kuch * ko ( maan ke). To low ko turant 0 pe clamp kar do (kyunki negative open-brackets ka matlab nahi banta — ek se kam to 0 hi hoga).

Lekin agar high kabhi negative ho jaye — iska matlab hai poori string ussi point pe invalid ho chuki hai, kyunki even best case mein bhi zyada ) hain ( se. Turant false return kar do.*/
class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int low = 0;
        int high = 0;
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(c=='(')
            {
                low++;
                high++;
            }
            else if(c==')')
            {
                low--;
                high--;
            }
            else
            {
                low--;
                high++;   
            }
            if(low<0)
            {
                low=0;
            }
            if(high<0)
            {
                return false;
            }
        }
        return low==0;//agr low 0 hai toh mtlbh sb kuch iterate bhi hogya h or kuch bacah ni mtlbh harr bracket ko apna saathi mil gya
    }
}