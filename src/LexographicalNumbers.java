    import java.util.ArrayList;
    import java.util.List;

    public class LexographicalNumbers {
        public static void main(String[] args) {
            int n = 125;

            System.out.println(lexicalOrder(n));
        }





        public static List<Integer> lexicalOrder(int n) {

            List<Integer> list = new ArrayList<>();

            for (int i = 1; i <= 9; i++) {
                solve(i, n, list);
            }

            return list;
        }

        static void solve(int i, int n, List<Integer> list) {

            if (i > n) {
                return;
            }

            list.add(i);

            int next = i * 10;

            while (next <= n && next < (i + 1) * 10) {
                solve(next, n, list);
                next++;
            }
        }
//        public static List<Integer> lexicalOrder(int n) {
//
//
//            int i = 1;
//            List<Integer> list = new ArrayList<>();
//
//            while (list.size() != n ) {
//
//                list.add(i);
//
//                int next = i * 10;
//
//                while (next <= n && next < (i + 1) * 10) {
//                    list.add(next);
//                    next++;
//                }
//                i++;
//            }
//
//            return list;
//        }
    }
