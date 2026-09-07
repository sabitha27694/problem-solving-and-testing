class SumInLeavesVisitor extends TreeVis {
    private int result = 0;
    
    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        // do nothing
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductRedNodesVisitor extends TreeVis {
    private long result = 1;
    private final int MOD = 1000000007;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int nonLeafEvenDepthSum = 0;
    private int greenLeavesSum = 0;

    public int getResult() {
        return Math.abs(nonLeafEvenDepthSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nonLeafEvenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeavesSum += leaf.getValue();
        }
    }
}

public class Solution {
    private static int[] values;
    private static Color[] colors;
    private static HashMap<Integer, HashSet<Integer>> map;

    public static Tree solve() {
        Scanner scan = new Scanner(System.in);
        int numNodes = scan.nextInt();
        
        values = new int[numNodes];
        colors = new Color[numNodes];
        map = new HashMap<>(numNodes);

        for (int i = 0; i < numNodes; i++) {
            values[i] = scan.nextInt();
        }
        for (int i = 0; i < numNodes; i++) {
            colors[i] = scan.nextInt() == 0 ? Color.RED : Color.GREEN;
        }
        for (int i = 0; i < numNodes - 1; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            
            map.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            map.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }
        scan.close();

        if (numNodes == 1) {
            return new TreeLeaf(values[0], colors[0], 0);
        }

        TreeNode root = new TreeNode(values[0], colors[0], 0);
        addChildren(root, 1);
        return root;
    }

    private static void addChildren(TreeNode parent, int parentNum) {
        for (int treeNum : map.get(parentNum)) {
            map.get(treeNum).remove(parentNum);
            HashSet<Integer> grandChildren = map.get(treeNum);
            boolean childHasChild = (grandChildren != null && !grandChildren.isEmpty());
            
            Tree tree;
            if (childHasChild) {
                tree = new TreeNode(values[treeNum - 1], colors[treeNum - 1], parent.getDepth() + 1);
                parent.addChild(tree);
                addChildren((TreeNode) tree, treeNum);
            } else {
                tree = new TreeLeaf(values[treeNum - 1], colors[treeNum - 1], parent.getDepth() + 1);
                parent.addChild(tree);
            }
        }
    }
}