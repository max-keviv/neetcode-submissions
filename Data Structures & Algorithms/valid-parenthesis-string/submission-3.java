class Solution {
    public boolean checkValidString(String s) {
        int mxLeft = 0, mnLeft = 0, n = s.length();

        for(int i=0;i<n;i++)
        {
            if(s.charAt(i) == '(') {
                mxLeft++;
                mnLeft++;
                }
            else if(s.charAt(i) == ')') {
                mxLeft--;
                mnLeft--;
            }
            else{
                mxLeft++;
                mnLeft--;
            }
            if(mxLeft < 0) return false;
            if(mnLeft < 0) mnLeft = 0;
        }
        if(mnLeft == 0) return true;
        return false;
    }
}

// ***(((
// )))***
// (((***
// ***)))

// when ")" > "(" + "*" 
// count of left 
// count of asterisk but if * appear before ( then only increase the optionalMxLeft, 
//  
