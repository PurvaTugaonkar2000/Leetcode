/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node curr = root;
        Node next = root;
        if(root != null){
         next = root.left;
        }
        while(curr!= null && next!= null){
            curr.left.next = curr.right;
            if(curr.next != null){
                curr.right.next = curr.next.left;
            }
            curr = curr.next;
            if(curr == null){
                curr = next;
                next = curr.left;
            }
        }
        return root;
    }
}