package Trees.FiftyQRush;

import Trees.TreeNode;

// Misunderstood the question




// See the thing is.
// the path should follow downwards
// i.e. parent child relationship should be maintained
/*

        1
      /   \
    2       3
  /  \     /  \
 4   5    6    7

 */

// leaf nodes cannot be connected to parent nodes
// that means 4 -> 2 -> is not a path


public class Q24CPathSumThree {
    public static void main(String[] args) {

    }

    public static int find(TreeNode root,int k){

        if(root == null){
            return 0;
        }

        return  PathSum(root,k) + find(root.left,k) + find(root.right,k);

    }
//      The problem here is passing count as a variable in wrong, it leads to double counting
//    public static int PathSum(TreeNode root,int k,int count){
//
//        if(root == null){
//            return 0;
//        }
//
//        k-= root.data;
//        if(k==0){
//            count++;
//        }
//
//        count += PathSum(root.left, k,count);
//        count += PathSum(root.right,k,count);
//
//        return count;
//
//    }


    // This one is correct as we are not double counting
    public static int PathSum(TreeNode root, int k){

        if(root == null){
            return 0;
        }

        int count = 0;

        k -= root.data;

        if(k == 0){
            count++;
        }

        count += PathSum(root.left, k);
        count += PathSum(root.right, k);

        return count;
    }

}
