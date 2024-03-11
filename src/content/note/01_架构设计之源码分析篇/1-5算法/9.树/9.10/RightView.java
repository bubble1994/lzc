/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
public List<Integer> rightSideView(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
        return result;  
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      boolean findRight = false;
      while (!queue.isEmpty()) {
        int size = queue.size();
        findRight = false;
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (!findRight) {
              result.add(node.val);
              findRight = true;
            }
            // 4 5
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
        }
      }
      return result;
    }
}