
/**
 * Balanced Binary Tree
 * 110. https://leetcode.com/problems/balanced-binary-tree/
 *
 * Q: Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 *  "a binary tree in which the left and right subtrees of every node differ in height by no more than 1."
 *
 * i.e.1
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * i.e.2
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * i.e.3
 * Input: root = []
 * Output: true
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5000].
 * -10^4 <= Node.val <= 10^4
 */
public class BalancedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        if (getHeight(root) == -1){
            return false;
        }

        return true;

    }

    public int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == -1 || right == -1){
            return -1;
        }

        if (Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args){

    }

    {
        // Ex1
        //  * Input: root = [3,9,20,null,null,15,7]
        //  * Output: true
        int[] input = {3,9,20,null,null,15,7};
        root = new TreeNode(intput[0]);
        for (int i = 1; i <= input.length; i++){

        }
    }
}
