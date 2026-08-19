package Recursion;

public class Recursion11 {
    public static void main(String[] args) {

        String s = "apnacollege";
        System.out.println(removeDuplicates(s));

    }


    // ONE IMPORTANT THING i noticed is you can actually use functions on param, suppose sb.append(char) is also possible. Watch the video

    // helper function for sending more required data
    public static String removeDuplicates(String s){
        StringBuilder sb = new StringBuilder();
        boolean [] arr = new boolean[26];
        String ans = remove(s,0,sb,arr);



        return ans;
    }


    // Building the String
    public static String remove(String s, int i, StringBuilder sb,boolean [] arr){

        if(i==s.length()){
            return sb.toString();
        }

        if(!arr[s.charAt(i) - 'a']){
            sb.append(s.charAt(i));
            arr[s.charAt(i)-'a'] = true;
        }

        return remove(s,i+1,sb,arr);


    }
}
