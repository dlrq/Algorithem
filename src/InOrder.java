

import java.util.LinkedList;
import java.util.List;

public class InOrder {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(inOrder(root));
    }

    public static List<Integer> inOrder(TreeNode root){
        List<Integer> res  = new LinkedList<>();
        if(root == null) return res;
        TreeNode cur = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
