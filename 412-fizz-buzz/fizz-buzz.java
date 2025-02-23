class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> a = new ArrayList<String>();
        for(int i=1;i<=n;i++){
            if (i%15==0){
                a.add("FizzBuzz");
            }else if(i%3==0){
                a.add("Fizz");
            }else if(i%5==0){
                a.add("Buzz");
            }else{
                String s = String.valueOf(i);
                // String s = new String(i);
                a.add(s);
            }
        }
        return a;
        
    }
}