class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // String[] s1 = sentence1.split(" ");
        // String[] s2 = sentence2.split(" ");
        // int n1=s1.length;
        // int n2=s2.length;
        // if(n1==n2) return sentence1.equals(sentence2); 

        // if(n1<n2) return  areSentencesSimilar(sentence2,sentence1);

        // int i=0,j=sentence2.length()-1;
        // int i2=0,j2=sentence1.length()-1;

        // while(i<sentence2.length() && sentence1.charAt(i2)==sentence2.charAt(i)){
        //     i++;
        //     i2++;
        // }
        // while(j>=0 && sentence1.charAt(j2)==sentence2.charAt(j)){
        //     j--;
        //     j2--;
        // }

        // return (j<i)?true:false;


        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int n1=s1.length;
        int n2=s2.length;

        if(n1<n2) return  areSentencesSimilar(sentence2,sentence1);

        int i=0,j1=n1-1;
        int j2=n2-1;

        while(i<n2 && s1[i].equals(s2[i])){
            i++;
        }
        while(j2>=i && s1[j1].equals(s2[j2])){
            j1--;
            j2--;
        }

        return (j2<i);

        
    }
}