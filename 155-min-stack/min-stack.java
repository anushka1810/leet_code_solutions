class MinStack {
    Stack<Long> st=new Stack<>();
    long minV=0;
    public MinStack() {
    }
    
    public void push(int val) {
        long x=(long)val;
        if(st.isEmpty()){
            st.push(x);
            minV=x;
        }else{
            if(x<minV){
                st.push(2*x-minV);
                minV=x;
            }else{
                st.push(x);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        if(st.peek()<minV){           //do not use== sign as it compare object reference 
            minV=2* minV-st.peek();   //2*val-oldMinV==St.peek();     aur min=val-----------hr ek push pe                                    //toh hrr ek pop pe oldMinV=st.peek()-2*minV
        }
        st.pop();
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        if(st.peek()<minV){
            return (int)minV;
        }
        long ans=st.peek();
        return (int)ans;
    }
    
    public int getMin() {
        if(st.isEmpty()){
            return -1;
        }
        return (int)minV;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */