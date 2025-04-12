class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> list=new ArrayList<>();
        ArrayList<String> list11 = new ArrayList<>(Arrays.asList(list1));
        ArrayList<String> list22 = new ArrayList<>(Arrays.asList(list2));
        int sum=Integer.MAX_VALUE;;
        for(int i=0;i<list11.size();i++){
            if(list22.indexOf(list11.get(i))!=-1){
                if(i+list22.indexOf(list11.get(i))<sum){
                    list.clear();
                    list.add(list11.get(i));
                    sum=i+list22.indexOf(list11.get(i));
                }
                else if(i+list22.indexOf(list11.get(i))==sum){
                    list.add(list11.get(i));
                }
            }
        }
          String array[] = list.toArray(new String[0]);
          return array;
        }

    
}