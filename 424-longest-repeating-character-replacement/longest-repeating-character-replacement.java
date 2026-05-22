// class Solution {
//     public int characterReplacement(String s, int k) {

//         int i=0,j=0;
//         HashMap<Character,Integer> h=new HashMap<>();
//         int ans=Integer.MIN_VALUE;

//         while(j<s.length()){
//             h.put(s.charAt(j),h.getOrDefault(s.charAt(j),0)+1);

//             while(i<j && h.size()>=2){
//                 if(h.size()>2){
//                     while(h.size()>2){
//                         h.put(s.charAt(i),h.get(s.charAt(i))-1);
//                         if(h.get(s.charAt(i))==0) h.remove(s.charAt(i));
//                         i++;
//                     }
//                 }else if(h.size()==2){
//                     char minVal='.';
//                     int min=Integer.MAX_VALUE;
//                     for(char ch:h.keySet()){
//                         if(h.get(ch)<min){
//                             min=h.get(ch);
//                             minVal=ch;
//                         }
//                     }

//                     while(i<j && h.size()==2 && h.get(minVal)>k){
//                         h.put(s.charAt(i),h.get(s.charAt(i))-1);
//                         if(h.get(s.charAt(i))==0) h.remove(s.charAt(i));
//                         i++;
//                     }
//                 }
//             }
//             if(h.size()==2){
//                 ans=Math.max(ans,j-i+1);
//             }
//             j++;

//         }

//         return ans;

//     }
    
// }




class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> h=new HashMap<>();
        int i=0,j=0,max=Integer.MIN_VALUE;
        char ele='.';
        int ans=Integer.MIN_VALUE;

        while(j<s.length()){
            h.put(s.charAt(j),h.getOrDefault(s.charAt(j),0)+1);
            if(h.get(s.charAt(j))>=max){
                max=h.get(s.charAt(j));
                ele=s.charAt(j);
            }

            
            // int replace=j-i+1-max;

            while(i<=j && j-i+1-max>k){
                h.put(s.charAt(i),h.getOrDefault(s.charAt(i),0)-1);
                i++;
            }

            ans=Math.max(ans,j-i+1);
            j++;
        }

        return ans;

    }
}