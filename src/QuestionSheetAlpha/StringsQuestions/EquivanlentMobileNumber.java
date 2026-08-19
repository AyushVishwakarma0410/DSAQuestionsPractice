package QuestionSheetAlpha.StringsQuestions;

public class EquivanlentMobileNumber {

    public static void equivalentMoBnumber(String s){

        StringBuilder sb  = new StringBuilder();

        for(int i = 0 ; i < s.length();i++){

            switch (s.charAt(i)) {
                case 'A':
                    sb.append(2);
                    break;
                case 'B':
                    sb.append(22);
                    break;
                case 'C':
                    sb.append(222);
                    break;
                case 'D':
                    sb.append(3);
                    break;
                case 'E':
                    sb.append(33);
                    break;
                case 'F':
                    sb.append(333);
                    break;
                case 'G':
                    sb.append(4);
                    break;
                case 'H':
                    sb.append(44);
                    break;
                case 'I':
                    sb.append(444);
                    break;
                case 'J':
                    sb.append(5);
                    break;
                case 'K':
                    sb.append(55);
                    break;
                case 'L':
                    sb.append(555);
                    break;
                case 'M':
                    sb.append(6);
                    break;
                case 'N':
                    sb.append(66);
                    break;
                case 'O':
                    sb.append(666);
                    break;
                case 'P':
                    sb.append(7);
                    break;
                case 'Q':
                    sb.append(77);
                    break;
                case 'R':
                    sb.append(777);
                    break;
                case 'S':
                    sb.append(7777);
                    break;
                case 'T':
                    sb.append(8);
                    break;
                case 'U':
                    sb.append(88);
                    break;
                case 'V':
                    sb.append(888);
                    break;
                case 'W':
                    sb.append(9);
                    break;
                case 'X':
                    sb.append(99);
                    break;
                case 'Y':
                    sb.append(999);
                    break;
                case 'Z':
                    sb.append(9999);
                    break;
                case ' ':
                    sb.append(0 );
                    break;
                default:
            }



        }
        System.out.println(sb);

    }

    public static void keyPad(String s){

        String [] keypad = {"","", "ABC", "DEF", "GHI",
                "JKL", "MNO", "PQRS", "TUV", "WXYZ"};


        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {

                if(ch == ' '){
                    sb.append(0);
                    continue;
                }

                for(int digit = 2; digit <=9; digit++){
                        int pos = keypad[digit].indexOf(ch);
                        if(pos!=-1){
                            sb.append(String.valueOf(digit).repeat(pos+1));
                            break;
                        }
                }

        }
        System.out.println(sb);
    }


    public static void main(String[] args) {
                String s  = "HELLO WORLD";
                equivalentMoBnumber(s);
    }
}
