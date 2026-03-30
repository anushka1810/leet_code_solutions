class Solution {
    public int evalRPN(String[] tokens) {
        // Stack<Integer> stack=new Stack<>();
        // for(String ch:tokens){
        //     if(ch.equals("+")||ch.equals("*")||ch.equals("-")||ch.equals("/")){
        //         int a=stack.pop();
        //         int b=stack.pop();
        //         if(ch.equals('+')){
        //             stack.push(b+a);
        //         }
        //         else if(ch.equals('*')){
        //             stack.push(b*a);
        //         }
        //         else if(ch.equals('-')){
        //             stack.push(b-a);
        //         }
        //         else if(ch.equals('/')){
        //             stack.push(b/a);
        //         }
        //     }else{
        //         stack.push(Integer.valueOf(ch));
        //     }
        // }

        // return stack.peek();



        Stack<Integer> s=new Stack<>();
        for(String ch:tokens){
            if(ch.equals("+")||ch.equals("-")||ch.equals("*")||ch.equals("/")){
                int v2=s.pop();
                int v1=s.pop();
                switch(ch){
                    case "+":
                    s.push(v1+v2);
                    break;
                    case "-":
                    s.push(v1-v2);
                    break;
                    case "*":
                    s.push(v1*v2);
                    break;
                    case "/":
                    s.push(v1/v2);
                    break; 
                }
            }else{
                s.push(Integer.valueOf(ch));
            }
        }
        return s.peek();

    }
}