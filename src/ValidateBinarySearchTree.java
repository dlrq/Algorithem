import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        isValidBSTHelper(root, list);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) <= list.get(i -1 )){
                return false;
            }
        }
        return true;
    }

    public void isValidBSTHelper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        isValidBSTHelper(root.left, list);
        list.add(root.val);
        isValidBSTHelper(root.right, list);
    }
}
