/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null, curr = slow;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        ListNode left = head, right = prev;
        while(right!= null){
            if(left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}