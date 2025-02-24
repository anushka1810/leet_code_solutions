class Solution {
    public int dayOfYear(String date) {
        String d[]=date.split("-");
        int year=Integer.valueOf(d[0]);
        int month=Integer.valueOf(d[1]);
        int da=Integer.valueOf(d[2]);
        int noofdays[]={31,28,31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if((year%4==0 && year%100!=0)||(year%400==0)){
            noofdays[1]=29;
        }
        int day=0;
        for(int i=0;i<month-1;i++){
            day=day+noofdays[i];
        }
        return day+da;
    }
}