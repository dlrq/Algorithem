import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
    public static void main(String[] args){

    }

    public static List<List<Integer>> levelOrder(Node root) {
        if(root == null) return null;
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for(int i = 0;i<size;i++){
                Node node = queue.poll();
                for(Node n:node.children){
                    queue.offer(n);
                }
                level.add(node.val);
            }
            res.add(level);
        }
        return res;
    }

    public static List<List<Integer>> levelOrder2(Node root){
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    public static void helper(Node root,int level,List<List<Integer>> res){
        if(root == null) return;
        if(res.size() < level){
            res.add(new LinkedList<>());
        }
        res.get(level).add(root.val);
        for(Node node:root.children){
            helper(node, level+1, res);
        }
    }
}
