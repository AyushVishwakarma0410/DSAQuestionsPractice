package Recursion;

public class Recursion10 {

//    it's quite a heck of a problem so use logic and figure out that it is following fibo series.
    public static void main(String[] args) {
        System.out.println(tileFilling(6));
    }
    public static int tileFilling(int n){

        if(n==2 || n==1){
            return n;
        }

        /*
        *   I redefined my code so that I can understand it more properly
        *   the condition as you can see  --

                    if(n==2 || n==1){
                        return n;
                    }

        *   gives you an understanding about this question.
        *   Suppose you are putting a single tile, then you have only 1 way, so your base case says if 1 then 1
        *   Suppose you are putting two tiles, then you have 2 ways ( both horiz. or both verti.) so if 2 then 2
        *   Now suppose you are putting 3 tiles, then you have 3 ways in total ( draw yourself) .
        *   - > as you can see 3 is f(1) + f(2).
        *   This is the pattern following the fibonacci series.
        *   In general, we use n == 0 || n == 1 return 1; because there is a shit talk which says putting no tile is also a way.
        *   This condition somehow covers for n==2 as well, as f(2 - 1) call will give 1 and f( 2-2) call will also give 1.
        *   So if you want to cover such cases, use-
        *                           if( n == 0 || n == 1 ) return 1 ;
        * */


        int verticalTiles = tileFilling(n-1);
        int horizontalTiles = tileFilling(n-2);

        return verticalTiles+horizontalTiles;


    }
}
