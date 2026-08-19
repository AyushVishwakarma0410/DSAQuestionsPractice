package BackTracking;

public class RatInAMaze {
    public static void main(String[] args) {

        int [][] maze =  { {1, 1},
                {1, 1} };

        System.out.println( rat(maze,0,0));;

    }
    public static int rat(int [][] maze,int i,int j){

        if(i==maze[0].length || i < 0 || j==maze.length || j < 0 || maze[i][j]==0){
            return 0;
        }


        // this else block is wrong
//        else{
//            maze[i][j] =0 ;
//        }


        if(i == maze[0].length-1 && j == maze.length-1){
            return 1;
        }

        // pehle mene else block pr daal dia tha too usse mene jo rasta band kia tha vo kabhi wapas khola hi ni too code ne hug dia :)
        maze[i][j] = 0;




        int way1 =  rat(maze,i+1,j);

        int way2 = rat(maze,i,j-1);

        int way3 = rat(maze,i,j+1);

        int way4 = rat(maze,i-1,j);

        maze[i][j] = 1;

        return way1+way2+way3+way4;
    }
}
