package Recursion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseAString {

    public static void main(String[] args) {
        String s = "Hello World, World is doomed";
        StringBuilder sb = new StringBuilder();
        System.out.println(rev(s,s.length()-1,sb));


        char [] c = {'h','e','l','l','o'};

        revStringArray(c,0,c.length-1);

        System.out.println(Arrays.toString(c));


    }

    public static String rev(String s,int i,StringBuilder sb){

        if(i==-1){
            return sb.toString();
        }

        sb.append(s.charAt(i));

        return rev(s,i-1,sb);



    }

    public static void swap(char[]s , int a, int b){

        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;


    }

    public static void revStringArray(char [] s, int start, int end){

        if(start>= end){
            return;
        }


        swap(s,start,end);

        revStringArray(s,start+1,end-1);
    }

}
