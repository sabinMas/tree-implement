import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Traversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(9);
        root.left.left = new TreeNode<>(5);
        root.left.left.right = new TreeNode<>(2);
        root.right = new TreeNode<>(15);
        root.right.left = new TreeNode<>(-3);
        root.right.right = new TreeNode<>(5);
        root.right.right.right = new TreeNode<>(22);

        TreeNode<Integer> megaRoot = new TreeNode<>(1);
        TreeNode<Integer> current = megaRoot;

        for (int i = 1; i < 100_001; i++) {
            current.right = new TreeNode<>(i);
            current = current.right;
        }

        // preorder(root);
        // postorder(root);
        // inorder(root);
        // preorderIterative(root);
        levelOrder(root);
    }

    public static void preorderIterative(TreeNode<?> root) {
        if (root == null) return;

        Stack<TreeNode<?>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<?> current = stack.pop();

            System.out.println(current.data);

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public static void preorder(TreeNode<?> current) {
        if (current == null) return;
        System.out.println(current.data);

        preorder(current.left);
        preorder(current.right);
    }

    public static void postorder(TreeNode<?> current) {
        if (current == null) return;
        postorder(current.left);
        postorder(current.right);
        System.out.println(current.data);
    }

    public static void inorder(TreeNode<?> current) {
        if (current == null) return;
        inorder(current.left);
        System.out.println(current.data);
        inorder(current.right);
    }


    public static void levelOrder(TreeNode<?> root){
      Queue<TreeNode<?>> queue = new LinkedList<>(); 

      queue.offer(root);

      while(!queue.isEmpty()) {
        TreeNode<?> current = queue.remove();
        if(current == null) continue; 
        System.out.print(current.data);
        queue.offer(current.left);
        queue.offer(current.right);
      }
    }
}