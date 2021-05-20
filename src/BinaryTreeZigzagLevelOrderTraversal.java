import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>(size);
            for(int i = 0;i < size;i++){
                TreeNode treeNode = queue.poll();
                tmp.add(treeNode.val);
                if(treeNode.left != null) queue.offer(treeNode.left);
                if(treeNode.right != null) queue.offer(treeNode.right);
            }
            if((level & 1) == 0) Collections.reverse(tmp);
            res.add(tmp);
            level++;
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    public void helper(TreeNode root, int level, List<List<Integer>> res){
        if(root == null) return;
        if(res.size() == level){
            res.add(new LinkedList<>());
        }
        if((level & 1) == 0) {
            res.get(level).add(root.val);
        }else{
            res.get(level).add(0, root.val);
        }
        helper(root.left, level + 1, res);
        helper(root.right, level + 1, res );
    }
}
