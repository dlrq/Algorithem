import java.util.LinkedList;
import java.util.List;

public class PostOrder {
    public static void main(String[] args){

    }

    public static List<Integer> postOrder(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode cur = root;
        while(!stack.isEmpty()){
            cur = stack.pop();
            res.add(0, cur.val);
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }
        return res;
    }
}
