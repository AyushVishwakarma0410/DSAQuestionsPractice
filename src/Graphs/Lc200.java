    package Graphs;




// When i looked at this question, i thought how the f i am going to solve it.
// later i started doing it, and then i cooked the question, did it




    // 10000000000000000000000 %%% self done



    // Lesson learned -> fucking try it, the brain will run, do some exercise
    // this is graph question not backtracking

    public class Lc200 {
        public static void main(String[] args) {



            char[][] s = {
                    {'0','1','1'},
                    {'1','1','0'},
                    {'1','1','0'}
            };

            System.out.println(numIslands(s));
        }
        public static int numIslands(char[][] grid) {

            int count = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length;j++) {
                    if(grid[i][j]=='1'){
                        count(grid,i,j);
                        count++;
                    }
                }
            }

            return count;
        }

        public static int count(char[][] grid,int i, int j){


            if(i >= grid.length || i < 0){
                return 0;
            }

            if(j >= grid[0].length || j < 0){
                return 0;
            }

            if(grid[i][j]=='0' || grid[i][j]=='2'){
                return 0;
            }

            if(grid[i][j]=='1'){
                grid[i][j] = '2';
            }

            count(grid,i+1,j);
            count(grid,i-1,j);
            count(grid,i,j+1);
            count(grid,i,j-1);




            return 1;

        }

    }
