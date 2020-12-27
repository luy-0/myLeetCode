

public class Offer26 {

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val && isEqual(A, B)) {
            return true;
        }
        boolean condition2 = isSubStructure(A.left, B);
        boolean condition3 = isSubStructure(A.right, B);
        return condition2 || condition3;
    }

    private boolean isEqual(TreeNode STree, TreeNode DTree) {
        if(DTree == null){
            return true;
        }
        if(STree == null){
            return false;
        }
        return (STree.val == DTree.val)
            && isEqual(STree.left, DTree.left)
            && isEqual(STree.right, DTree.right);
    }
}