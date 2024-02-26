import java.util.ArrayList;
import java.util.List;

// TC - O(N)
// SC - O(h)

public class TreeRowLargestDFS {

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
        private List<Integer> levelLargestValueList;

        public List<Integer> largestValues(TreeNode root) {
            levelLargestValueList = new ArrayList<>();
            if (root == null) {
                return levelLargestValueList;
            }

            dfs(root, 0);

            return levelLargestValueList;
        }

        private void dfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }

            if (levelLargestValueList.size() <= level) {
                levelLargestValueList.add(root.val);
            } else {
                levelLargestValueList.set(level, Math.max(root.val, levelLargestValueList.get(level)));
            }
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }
    }
}
