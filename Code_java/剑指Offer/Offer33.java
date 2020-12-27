public class Offer33 {

}

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length);
    }

    private boolean helper(int[] postorder, int start, int end) {
        if (start >= end - 1) {
            return true;
        }
        int root = postorder[end - 1];
        int index = -1;
        for (int i = start; i < end - 1; i++) {
            if (postorder[i] >= root) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < end - 1; i++) {
                if (postorder[i] < root) {
                    return false;
                }
            }
            return helper(postorder, start, index) && helper(postorder, index, end - 1);
        }
        return helper(postorder, start, end - 1);
    }
}