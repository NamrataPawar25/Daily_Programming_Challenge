class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return (left != null) ? left : right;
    }

    public static TreeNode buildExampleTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        return root;
    }

  
    public static void main(String[] args) {
        LowestCommonAncestor lcaSolver = new LowestCommonAncestor();
        TreeNode root = buildExampleTree();

        TreeNode p = root.left;              
        TreeNode q = root.right;            
        System.out.println("LCA of 5 and 1: " +
            lcaSolver.lowestCommonAncestor(root, p, q).val); 

        p = root.left;                       
        q = root.left.right.right;          
        System.out.println("LCA of 5 and 4: " +
            lcaSolver.lowestCommonAncestor(root, p, q).val); 

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        p = root2;                           
        q = root2.left;                      
        System.out.println("LCA of 1 and 2: " +
            lcaSolver.lowestCommonAncestor(root2, p, q).val); 
    }
}
