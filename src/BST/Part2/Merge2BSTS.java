package BST.Part2;

import Trees.TreeNode;

import java.util.ArrayList;

public class Merge2BSTS {
    public static void main(String[] args) {

    }
    public static TreeNode makeTree(ArrayList<Integer> list, int start, int end){

        if(start>end){
            return null;
        }

        int mid = start + (end - start) / 2;


        TreeNode root = new TreeNode(list.get(mid));

        root.left = makeTree(list,start,mid-1);
        root.right = makeTree(list,mid+1,end);

        return root;
    }
    public static TreeNode convert(TreeNode root1, TreeNode root2){

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        inorder(root1,list1);
        inorder(root2,list2);

        ArrayList<Integer> finalList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()){

            if(list1.get(i) < list2.get(j)) {
                finalList.add(list1.get(i));
                i++;
            }
            else {
                finalList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()){
            finalList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()){
            finalList.add(list2.get(j));
            j++;
        }


            return makeTree(finalList,0,finalList.size()-1);

    }

    public static void  inorder(TreeNode root, ArrayList<Integer> list){

        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);


    }

}
