class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Integer> asterisk = new Stack<>();
        Stack<Integer> left = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '('){
                left.push(i);
            } 
            else if(s.charAt(i) == ')'){
                if(!left.isEmpty()){
                    left.pop();
                }
                else if(!asterisk.isEmpty()){
                    asterisk.pop();
                }
                else {
                    return false;
                }
            }
            else{
                asterisk.push(i);
            }
        }
        while(!left.isEmpty() && !asterisk.isEmpty()){
            if(left.peek() > asterisk.peek()) 
            return false;
            left.pop();
            asterisk.pop();
            
        }
        return left.isEmpty();
    }
}

//  *** ((((
// ((( ***
// )))) ***
