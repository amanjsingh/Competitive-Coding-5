import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRowLargestBFS {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> largetstValueList = new ArrayList<>();

            if (root == null) {
                return largetstValueList;
            }

            queue.add(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                int levelMaxValue = Integer.MIN_VALUE;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currNode = queue.poll();
                    if (currNode.val > levelMaxValue) {
                        levelMaxValue = currNode.val;
                    }
                    if (currNode.left != null) {
                        queue.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.add(currNode.right);
                    }
                }
                largetstValueList.add(levelMaxValue);
            }

            return largetstValueList;
        }
    }
}