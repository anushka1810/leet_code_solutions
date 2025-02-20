class Solution {
    public String isvalid(char a,char b){
        int sum=a+b;
        System.out.println(sum);
        if((a>96 && a<105) && (b>48 && b<58 )){
            if(sum%2==0){
                return "black";
            }else{
                return "white";
            }
        }
        return "invalid";
    }
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        char arr1[]=coordinate1.toCharArray();
        char arr2[]=coordinate2.toCharArray();
        if(arr1.length==2 && arr2.length==2){
            String s1=isvalid(arr1[0],arr1[1]);
            String s2=isvalid(arr2[0],arr2[1]);
            System.out.println(s1);
            System.out.println(s2);
            if(s1.equals(s2)){
                return true;
            }
        }
        return false;
    }
}