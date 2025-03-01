class Solution {
    public int countSegments(String s) {
        s=s.trim();
        String[] a = s.split("\\s+");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        if(s.isEmpty()){
            return 0;
        }
        return a.length;
    }
}