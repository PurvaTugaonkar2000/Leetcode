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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        ListNode end = head;
        for(int i = 1; i <=k; i++){
            if(temp == null){
                return head;
            }
            if(i == k){
                end = temp;
            }
            temp = temp.next;
        }
        ListNode nextStart = end.next;
        end.next = null;
        reverse(head);
        head.next = reverseKGroup(nextStart, k);
        return end;
    }
    public void reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
    }
}