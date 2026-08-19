package Recursion;

public class Recursion12 {



// ek baar permutation dekh lena, take A B C D  and arrange them in order to get all possible arrangements.



    
    // This question is a fucking headache took a whole day and i am just 70 percent sure intuitively
    // bs ye yd rakh bhai.... f(n-1) and f(n-2) 2 call hain, thik ?
    // ab f1 jo hai uska ye matlab hai ki tu single hai ... thik agar tu single hai too tera koi kaam ni
    // kyuki maan le you are A in A B C so you decided to stay single
    // ab you decided to stay single that means ki B C jese jaenge to bhi vese hi jaega ?
    // dekh kese tu single hai ... BC have 2 choices stay singles or become a pair, if they become pair or stay single
    // then you can go two ways, so ultimately vo kese jaenge wahi tera answer bann jaega
    // ab baat krte hain f(n-2) wale call ki, isko mt dekh kyuki confuse ho jaega
    // consider this (n-1) f(n-2)
    // n - 1 kya hai ? dekh
    // suppose A B C D hain, okay ?
    // ab isme A ko jana hai pair m too bhai 2 log kamm ho jaenge group se
    // kyu kamm ho gye kyuki A ke saath koi hoga
    // ab bache C D unpr aagye 2 choice
    // CD = 2
    // agar tu C ke saath gya too BD will remain so again 2
    // and if D ke saath gya to 2 choices phr se, to total terpr 2 + 2 + 2 choices reh gyi
    // ab dhyan se dekh ki 3 baar 2 kyu aaya
    // kyuki tuune apna pair badla, agar tu pair badelga too choices bhi badlegi isliye single rehne pr 4 choices kyuki 3 log 4 trah se reh gy e
    // aur pair bnanae pr 6 choices kyuki tunne pairs badle
    // tu  n = 4 aur n = 5 lekar check kr pura samjh jaega














    public static void main(String[] args) {

        int n = 5;
        System.out.println(friendPairing(4));


    }


    // The thing you should actually notice is that, dont try to follow the real life simulation
    // follow the simulation of formation of numbers
    // In both problems, tile filling and friend pairing, if we try to follow the simulation, things become chaotic
    // But if we just only think about the number formation, things start to make sense, which was not happening
    // in the real life simulation


    // AND

    /*
    // Don’t simulate real life step-by-step.
    // These are counting problems, not action problems.
    // Fix one unit (tile / friend) and count possibilities.
    // Focus on recurrence (number formation), not configurations.
    */
















    // Rewatch video
    public static int friendPairing(int n){

        if(n==1 || n==2){
            return n;
        }



        // choice

        //single
        int f1 = friendPairing(n-1);
        // pair
        int f2 = friendPairing(n-2);


       /*
       So you are saying that suppose i am A, if i choose B then C and D will have 2 choices
            So i will just add with them
            If i choose C then again i have 2 cchoices
            If i choose D then again i have 2 choices

        here by choices i mean scenarios in which rest of the 2 will react and i will add them even though i dont care about them


        If so

            then if I ( A) have 4 choices say B C D E

                if i sticck with B i have 4 choices as E C D can make 4 scenarios
                if i stick with any i will have 4 choices
                so 4 if i choose B , 4 if i choose C, 4 if i choose D, and 4 i choose E
                so total 16 choices if A deicided to be in a pair?

       * */

        int pairWays = (n-1) * f2;

        // total
        int  totalWays = f1 + pairWays;

        return totalWays;

    }



    public static int friendPair(int n){


        if(n==1|| n == 2 ){
            return n;
        }

        // for single choice, the other people combinations will be your answer
        // as you just have to be added with it
        // for paired choice you will take a person so n - 2 will be the choices you have but since you can choose
        // n-1 people you will multiply with n -1 so that all combinations can be counted.
        return friendPair(n-1) + (n-1) * friendPair(n-2);



    }

// pairWays = (n-1) * friendPairing(n-2)

    /*
Tiny example (n = 4)

Friends: a b c d
Let d be the last friend.

Pair d with:

a → remaining: b c → friendPairing(2) = 2

b → remaining: a c → friendPairing(2) = 2

c → remaining: a b → friendPairing(2) = 2
* 3 × 2 = 6

    *
    *
    * */


}
