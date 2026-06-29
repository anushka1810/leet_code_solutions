class MinStack {
    Stack<Long> st;
    long MinV=0;
    public MinStack() {
       st=new Stack<>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push((long)value);
            MinV=(long)value;
        }else{
            if(value<MinV){
                long val=(long)2*value-MinV;
                st.push(val);
                MinV=(long)value;
            }else{
                st.push((long)value);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }else{
            if(st.peek()<MinV){
                long oldMin=2*MinV-st.peek();
                st.pop();
                MinV=oldMin;
            }else{
                st.pop();
            }
        }   
    }
    
    public int top() {
        if(st.peek()<MinV){
            return (int)MinV;
        }else{
            long ans=st.peek();
            return (int)ans;
        }
    }
    
    public int getMin() {
        return (int)MinV;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */