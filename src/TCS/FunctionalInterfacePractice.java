package TCS;

public class FunctionalInterfacePractice {

    @FunctionalInterface
     interface interf{
        default void m2(){
            System.out.println("This is default!!");
        }
        public void m1();
    }


//    // Normal way
//     static class Demo implements interf{
//        @Override
//        public void m1() {
//            System.out.println("Hello world");
//        }
//    }

    public static void main(String[] args) {



//    interf i = new Demo();

//    i.m1();



    // JAVA 8 -> Lambda expression
        interf Fi = () -> System.out.println("hello world");
        Fi.m1();
        Fi.m2();


    }



}
