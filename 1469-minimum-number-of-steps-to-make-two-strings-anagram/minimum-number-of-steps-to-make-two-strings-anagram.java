class Solution {
    // public int minSteps(String s, String t) {
    //     HashMap<Character,Integer> freq=new HashMap<>();
    //     for(int i=0;i<s.length();i++){
    //         freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)+1);
    //         freq.put(t.charAt(i),freq.getOrDefault(t.charAt(i),0)-1);
    //     }
    //     int ans=0;
    //     for(char ch:freq.keySet()){
    //         if(freq.get(ch)>0){
    //             ans+=freq.get(ch);

    //         }
    //     }
    //     return ans;
    // }

    public int minSteps(String s, String t) {
        int arr1[]=new int[26];

        for(int i=0;i<s.length();i++){
            arr1[s.charAt(i)-'a']++;
            arr1[t.charAt(i)-'a']--;
        }

        int ans=0;
        for(int num:arr1){
            if(num>0) ans+=num;
        }
        return ans;


    }
}